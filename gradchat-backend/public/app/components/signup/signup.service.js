angular.module('chatApp').factory('SignupService', ['$http',
    function ($http) {

        return {

                post: (data) => $http.post('/chat/users',data).then(response => response.data)
    };
    }
])
