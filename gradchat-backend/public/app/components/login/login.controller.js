angular.module('chatApp', ['ngCookies']).controller('LoginController',
    ['LoginService','$location', '$scope', function(LoginService,$location, $scope) {

        $scope.login = (user) => {
            LoginService.post(user).then(data=>{
                if(data.USER_ID != null && data.USER_ID != 0){
                    console.log(data);
                    document.location.href = '/';
                    $scope.loggeduser = data.USER_FIRSTNAME;
                } else {
                    console.log("User not found!")
                }
            });
        }
    }]);
