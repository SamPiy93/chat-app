angular.module('chatApp').factory('ChatService', ['$http',
    function ($http) {

        return {
            getUserList: () => $http.get('/chat/users').then(response => response.data),

            getMessagesList: (type) => $http.post('/chat/retrieve/messages', type).then(response => response.data),
        };
    }
])
