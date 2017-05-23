angular.module('chatApp').controller('SignupController',
    ['SignupService','$location', '$scope', function(SignupService,$location, $scope) {

        $scope.signup = (user) => {
            SignupService.post(user).then(data=>{
                console.log(data);
                if(data.USER_FIRSTNAME != null){
                document.location.href = '/login';
            } else {
                console.log("User Registration Failed!")
            }
        });
        }
    }]);
