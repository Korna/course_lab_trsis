var app = angular.module('Persons', []);

app.controller("PersonsController", function ($scope, $http) {

    $scope.getPersons = function () {

            $http.get('/rest/Persons').success(function (data, status, headers, config) {
                $scope.personList = data;

            }).error(function (data, status, headers, config) {
             /*   if (data.message === 'Time is out') {
                    $scope.finishByTimeout();
                }*/
                $scope.errorMessage=data.message;
                $scope.isAddError=true;
                $scope.isDeleteError=false;
                console.warn("Status code: " + status + "\nError: " + data.message);
            });

    };

    $scope.addPerson = function (name,  surname,  patronymic, passport,  position,  tolerance_level) {
        if (name==="") name=undefined;
        if (surname==="") surname=undefined;
        if (patronymic==="") patronymic=undefined;
        if (passport==="") passport=undefined;
        if (position==="") position=undefined;
        if (tolerance_level==="") tolerance_level=undefined;
        $http.post('/rest/Persons/add/' + name + "/" + surname + "/" + patronymic + "/" + passport + "/" + position + "/" + tolerance_level).success(function (data, status, headers, config) {
            $scope.isError=false;
            $scope.personList.splice(0, 0, data);
                               // console.log(data);
            }
        ).error(function (data, status) {
            $scope.errorMessage=data.message;
            $scope.isAddError=true;
            $scope.isDeleteError=false;
            console.warn("Status code: " + status + "\nError: " + data.message);

        });

    };
   $scope.deletePerson = function (passport) {
       if(passport==="") passport=undefined;
       $http.delete('/rest/Persons/delete/' + passport).success(function (data, status, headers, config) {
           $scope.isDeleteError = false;
           for (var i = 0; i < $scope.personList.length; i++) {
               var j = $scope.personList[i];
               if (angular.lowercase(j.passport) === angular.lowercase(passport)) {
                   $scope.personList.splice(i, 1);
                   break;
               }
           }
       }).error(function (data, status) {
           $scope.errorMessage = data.message;
           $scope.isDeleteError = true;
           $scope.isAddError = false;
           console.warn("Status code: " + status + "\nError: " + data.message);

       });
   };

    $scope.searchPerson = function (surname) {
        if (surname==="") surname = undefined;
        $http.post('/rest/SearchPerson/' + surname).success(function (data, status, headers, config) {
                $scope.isSearchError = false;
                $scope.personList = data;
            }
        ).error(function (data, status) {
            $scope.errorMessage = data.message;
            $scope.isSearchError = true;
            console.warn("Status code: " + status + "\nError: " + data.message);
        });
    };

    $scope.hideShow= function(hide_id){
        if (hide_id==="search") {
            $scope.isSearchError = false
        }
        else if(hide_id==="add")
        {
            $scope.isAddError = false
        }
        else if(hide_id==="delete")
        {
            $scope.isDeleteError = false
        }

    };

    $scope.allPosition = function () {

        $http.get('/rest/Persons/position/').success(function (data, status, headers, config) {
            $scope.positionList = data;

        }).error(function (data, status, headers, config) {
            /*   if (data.message === 'Time is out') {
                   $scope.finishByTimeout();
               }*/
            $scope.errorMessage=data.message;
            $scope.isAddError=true;
            $scope.isDeleteError=false;
            console.warn("Status code: " + status + "\nError: " + data.message);
        });

    };

    $scope.getLevel=function()
    {
        var select = document.getElementById("position");
        var mylevel = select.options[select.selectedIndex].value;
        $scope.tolerance_level = mylevel;
        $scope.position = select.options[select.selectedIndex].text;
    };


});


