/*
  * To change this license header, choose License Headers in Project Properties.
  * To change this template file, choose Tools | Templates
  * and open the template in the editor.
  */
 (function(ng){
     var mod = ng.module("medioModule",["ngMessages","ui.router"] );
     mod.constant("medioContext", "api/medio");
        mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
             var basePath = 'src/modules/medio/';
             $urlRouterProvider.otherwise("/medioList");

             $stateProvider.state('medioList', {
                 url: '/medio',
                 views: {
                     'mainView': {
                         controller: 'medioCtrl',
                         controllerAs: 'ctrl',
                         templateUrl: basePath + 'medio.list.html'
                     }
                 }
             }).state('medioCreate', {
                 url: '/medio/create',
                 views: {
                     'mainView': {
                         controller: 'medioCtrl',
                         controllerAs: 'ctrl',
                         templateUrl: basePath + 'medio.create.html'
                     }
                 }

             }).state('medioEdit', {
                 url: '/medio/:medioId',
                 param: {
                     medioId: null
                 },
                 views: {
                     'mainView': {
                         controller: 'medioCtrl',
                         controllerAs: 'ctrl',
                         templateUrl: basePath + 'medio.create.html'
                     }
                 }
             }).state('medioDelete', {
                url: '/medio/:medioId',
                param: {
                    medioId: null
                },
                views:{
                    'mainView': {
                        controller: 'medioCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'medio.delete.html'
                    }
                }
            });
        }]);
    
})(window.angular);
