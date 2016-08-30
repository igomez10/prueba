/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
  * To change this license header, choose License Headers in Project Properties.
  * To change this template file, choose Tools | Templates
  * and open the template in the editor.
  */
 (function(ng){
     var mod = ng.module("mediodepagoModule",["ngMessages"] );
     mod.constant("mediodepagoContext", "api/mediosdepago");
        mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
             var basePath = 'src/modules/mediodepago/';
             $urlRouterProvider.otherwise("/mediodepagoList");

             $stateProvider.state('mediodepagoList', {
                 url: '/mediosdepago',
                 views: {
                     'mainView': {
                         controller: 'mediodepagoCtrl',
                         controllerAs: 'ctrl',
                         templateUrl: basePath + 'mediodepago.list.html'
                     }
                 }
             }).state('mediodepagoCreate', {
                 url: '/mediosdepago/create',
                 views: {
                     'mainView': {
                         controller: 'mediodepagoCtrl',
                         controllerAs: 'ctrl',
                         templateUrl: basePath + 'mediodepago.create.html'
                     }
                 }

             }).state('mediodepagoEdit', {
                 url: '/mediosdepago/:mediodepagoId',
                 param: {
                     mediodepagoId: null
                 },
                 views: {
                     'mainView': {
                         controller: 'mediodepagoCtrl',
                         controllerAs: 'ctrl',
                         templateUrl: basePath + 'mediodepago.create.html'
                     }
                 }
             });
         }]);

 })(window.angular);
