var app = angular.module('Search', []);

app.controller("SearchController", function ($scope, $http) {
    $scope.searchPerson = function (surname) {
        if (surname === "") surname = undefined;
        $http.post('/rest/SearchPerson/' + surname).success(function (data, status, headers, config) {
                $scope.isSearchError = false;
                $scope.PersonList = data;
            }
        ).error(function (data, status) {
            $scope.errorMessage = data.message;
            $scope.isSearchError = true;
            console.warn("Status code: " + status + "\nError: " + data.message);
        });
    };
});
