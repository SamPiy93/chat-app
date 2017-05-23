angular.module('chatApp').factory('LoginService', ['$http',
    function ($http) {

        return {

            post: (data) => $http.post('/chat/login',data).then(response => response.data)
        };
    }
])
