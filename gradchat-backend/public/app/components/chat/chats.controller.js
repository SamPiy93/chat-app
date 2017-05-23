angular.module('chatApp').controller('ChatController',
    ['ChatService','$location', '$scope','$routeParams', '$cookies', function(ChatService,$location, $scope, $routeParams, $cookies) {

    function getUserListFunc() {
        ChatService.getUserList().then(users =>{
            $scope.users = users;
    })
    }

    $scope.loggedUser = $cookies.get("LOGGED_USER");
    // function getMessages(type) {
    //     ChatService.getMessages({"SENDER_ID":"1","RECIEVER_ID":"2"}).then(messages => {
    //         console.log(messages);
    //         $scope.messages = messages;
    //     })
    // }

    function fetchUserMessages(userId,senderId,userFirstName) {
        let query = {"RECIEVER_ID":userId, "SENDER_ID":senderId};
        ChatService.getMessagesList(query).then(messages => {
            $scope.senderName = userFirstName;
            $scope.messages = messages;
        })
    }
    $scope.fetchUserMessages = fetchUserMessages;

    $scope.fetchUserProfile = function(user){
        $location.path('/profile/'+user.USER_ID);
        $scope.firstName = user.USER_FIRSTNAME;
        $scope.lastName = user.USER_LASTNAME;
        $scope.email = user.USER_EMAIL;
        // alert("USER PROFILE\nName : "+firstName+" "+lastName+"\nEmail : "+email);
    };

    $scope.composeMessage = function(dateTime, senderId){
        var receiverId = $routeParams.id;
        // let message = prompt("Enter message here...","Enter message here...");
        console.log(receiverId);
        console.log(dateTime);
        console.log(senderId);
        console.log($scope.newMessage);
    };
    $scope.getDatetime = new Date();

    getUserListFunc();
        // getMessages({"SENDER_ID":"1","RECIEVER_ID":"2"});
    $scope.goToAdd = (user) => {
        $location.path('/chats/'+user.USER_ID);
        $scope.name = user.USER_FIRSTNAME;
        fetchUserMessages(user.USER_ID, '1', user.USER_FIRSTNAME)
    }
    // $scope.name = 'Test Name';
}]);
