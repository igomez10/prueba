/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
    var mod = ng.module("domiciliosModule", ["ngMessages","ui.router"]);
    mod.constant("domicilioContext", "api/domicilios");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/domicilios/';
            $urlRouterProvider.otherwise("/domicilioList");
     
            $stateProvider.state('domicilioList', {
                url: '/domicilios',
                views: {
                    'mainView': {
                        controller: 'scr/modules/domicilios/domicilios.ctrl.js',
                        controllerAs: 'domiciliosCtrl',
                        templateUrl: basePath + 'domicilios.list.html'
                    }
                }
            }).state('domicilioCreate', {
                url: '/cities/create',
                views: {
                    'mainView': {
                        controller: 'scr/modules/domicilios/domicilios.ctrl.js',
                        controllerAs: 'domiciliosCtrl',
                        templateUrl: basePath + 'domicilio.create.html'
                    }
                }

            }).state('domicilioEdit', {
                url: '/domicilios/:domicilioId',
                param: {
                    domicilioId: null
                },
                views: {
                    'mainView': {
                        controller: 'scr/modules/domicilios/domicilios.ctrl.js',
                        controllerAs: 'domiciliosCtrl',
                        templateUrl: basePath + 'domicilio.create.html'
                    }
                }
            });
        }]);
})(window.angular);
