angular.module('chatApp').controller('ChatController',
    ['ChatService','$location', '$scope','$routeParams', '$cookies', function(ChatService,$location, $scope, $routeParams, $cookies) {


        $scope.loggedUser = $cookies.get("LOGGED_USER");
        let thisUser = $scope.loggedUser;

        function getUserList() {

            ChatService.getUserList().then(users => {
                $scope.users = users;
            })
        }

        getUserList();

        function fetchUserMessages(userId,senderId,userFirstName) {

            let query = {"RECIEVER_ID":userId, "SENDER_ID":senderId};
            ChatService.getMessages(query).then(messages => {
                $scope.senderName = userFirstName;
                $scope.messages = messages;
            })
        }

        $scope.composeMessage = (date,senderId) => {
            var userId = $routeParams.id;
            let query = {"SENDER_ID":senderId, "RECIEVER_ID":userId, "MESSAGE_CONTENT":$scope.newMessage, "RECIEVED_ON":date};
            ChatService.sendMessage(query).then((response) => {
                    $scope.newMessage = "";
                ChatService.getUserByID(userId).then((data) => {
                    fetchUserMessages(userId, thisUser, data.USER_FIRSTNAME);
                })
            });

        };

        $scope.getDatetime = new Date();

        $scope.goToChats = (user) => {
            $location.path('/chats/'+user.USER_ID);
            $scope.name = user.USER_FIRSTNAME;
            fetchUserMessages(user.USER_ID, thisUser, user.USER_FIRSTNAME)
        }

        $scope.goToProfile = (user) => {
            $location.path('/profile/'+user.USER_ID);
        }
}]);
