/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(ng){
    var mod = ng.module("clienteModule",["ngMessages", "ui.router"] );
    mod.constant("clienteContext", "api/clientes");
       mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/cliente/';
            $urlRouterProvider.otherwise("/clienteList");
     
            $stateProvider.state('clienteList', {
                url: '/clientes',
                views: {
                    'mainView': {
                        controller: 'scr/modules/cliente/cliente.ctrl.js',
                        controllerAs: 'clienteCtrl',
                        templateUrl: basePath + 'cliente.list.html'
                    }
                }
            }).state('clienteCreate', {
                url: '/clientes/create',
                views: {
                    'mainView': {
                        controller: 'scr/modules/cliente/cliente.ctrl.js',
                        controllerAs: 'clienteCtrl',
                        templateUrl: basePath + 'cliente.create.html'
                    }
                }

            }).state('clienteEdit', {
                url: '/clientes/:clienteId',
                param: {
                    clienteId: null
                },
                views: {
                    'mainView': {
                        controller: 'scr/modules/cliente/cliente.ctrl.js',
                        controllerAs: 'clienteCtrl',
                        templateUrl: basePath + 'cliente.create.html'
                    }
                }
            });
        }]);
    
})(window.angular);


