angular.module('chatApp').factory('ChatService', ['$http',
    function ($http) {

        return {
            getUserList: () => $http.get('/chat/users').then(response => response.data),
            getUserByID: (id) => $http.get('/chat/users/'+ id).then(response => response.data),
            getMessages: (type) => $http.post('/chat/retrieve/messages', type).then(response => response.data),
            sendMessage: (message) => $http.post('/chat/messages', message).then(response => response.data)
        };
    }
])
