angular.module('chatApp').controller('LoginController',
    ['LoginService','$location', '$scope','$cookies', function(LoginService,$location, $scope, $cookies) {

        $scope.login = (user) => {
            LoginService.post(user).then(data=>{
                if(data.USER_ID != null && data.USER_ID != 0){
                    console.log(data);
                    document.location.href = '/';
                    $cookies.put("LOGGED_USER", data.USER_ID);
                } else {
                    console.log("User not found!")
                }
            });
        }
    }]);
