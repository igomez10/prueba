/*
  * To change this license header, choose License Headers in Project Properties.
  * To change this template file, choose Tools | Templates
  * and open the template in the editor.
  */
 (function(ng){
     var mod = ng.module("medioDePagoModule",["ngMessages","ui.router"] );
     mod.constant("medioDePagoContext", "api/medioDePago");
        mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
             var basePath = 'src/modules/medioDePago/';
             $urlRouterProvider.otherwise("/medioDePagoList");

             $stateProvider.state('medioDePagoList', {
                 url: '/medioDePago',
                 views: {
                     'mainView': {
                         controller: 'medioDePagoCtrl',
                         controllerAs: 'ctrl',
                         templateUrl: basePath + 'medioDePago.list.html'
                     }
                 }
             }).state('medioDePagoCreate', {
                 url: '/medioDePago/create',
                 views: {
                     'mainView': {
                         controller: 'medioDePagoCtrl',
                         controllerAs: 'ctrl',
                         templateUrl: basePath + 'medioDePago.create.html'
                     }
                 }

             }).state('medioDePagoEdit', {
                 url: '/medioDePago/:medioDePagoId',
                 param: {
                     medioDePagoId: null
                 },
                 views: {
                     'mainView': {
                         controller: 'medioDePpagoCtrl',
                         controllerAs: 'ctrl',
                         templateUrl: basePath + 'medioDePago.create.html'
                     }
                 }
             }).state('medioDePagoDelete', {
                url: '/medioDePago/:medioDePagoId',
                param: {
                    medioDePagoId: null
                },
                views:{
                    'mainView': {
                        controller: 'medioDePagoCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'medioDePago.delete.html'
                    }
                }
            });
        }]);
    
})(window.angular);
