var app = angular.module('exhibits', []);

app.controller("ExhibitsController", function ($scope, $http) {

    $scope.getExhibits = function () {
        $http.get('/public/rest/exhibits').success(function (data, status, headers, config) {
            $scope.exhibitsList = data;
        }).error(function (data, status, headers, config) {
            if (data.message === 'Time is out') {
                $scope.finishByTimeout();
            }
        });
    };

    $scope.delete = function (id) {
        $http.delete('/public/rest/exhibits/delete/' + id).success(function (data, status, headers, config) {
            for (var i = 0; i < $scope.exhibitsList.length; i++) {
                var j = $scope.exhibitsList[i];
                if (j.id === id) {
                    $scope.exhibitsList.splice(i, 1);
                    break;
                }
            }
        }).error(function (data, status, headers, config) {
            console.error(status, data, headers);
        });
    };

    $scope.addExhibit = function () {
        $http.post('/public/rest/exhibits/add/', {
            author: $scope.author,
            description: $scope.description,
            date: $scope.date
        })
            .success(function (data, status, headers, config) {
                    $scope.exhibitsList.push(data);
                }
            )
            .error(function (data, status, headers, config) {
                console.error(status, data, headers);
            });

        $scope.author = '';
        $scope.description = '';
        $scope.date = '';
    };
});
