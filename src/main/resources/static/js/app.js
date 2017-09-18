var app = angular.module('TestApp', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/users',{
            templateUrl: '/views/users.html',
            controller: 'usersController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});

