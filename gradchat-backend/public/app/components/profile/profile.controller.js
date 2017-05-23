/**
 * Created by sameerap on 23/05/2017.
 */
angular.module('chatApp').controller('ProfileController',
    ['ChatService','$location', '$scope','$routeParams', '$cookies', function(ChatService,$location, $scope, $routeParams, $cookies) {
        $scope.loggedUser = $cookies.get("LOGGED_USER");
        if($scope.loggedUser == undefined || $scope.loggedUser == null || $scope.loggedUser == 0){
            document.location.href = '/login';
        }
        var id = $routeParams.id;
        ChatService.getUserByID(id).then(user => {
            $scope.name = user.USER_FIRSTNAME;
            $scope.firstName = user.USER_FIRSTNAME;
            $scope.lastName = user.USER_LASTNAME;
            $scope.email = user.USER_EMAIL;
        })

}]);
