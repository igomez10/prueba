(function (ng) {
    var app = ng.module("sucursalModule", ["ngMessages","ui.router"]);
    app.constant("sucursalContext", "api/sucursales");
    app.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/sucursal/';
            $urlRouterProvider.otherwise("/RestauranteElSabor");
     
            $stateProvider.state('sucursalList', {
                url: '/sucursal',
                views: {
                    'mainView': {
                        controller: 'sucursalCtrl',
                        controllerAs: 'sucursalCtrl',
                        templateUrl: basePath + 'sucursal.list.html'
                    }
                }
            }).state('sucursalCreate', {
                url: '/sucursal/create',
                views: {
                    'mainView': {
                        controller: 'sucursalCtrl',
                        controllerAs: 'sucursalCtrl',
                        templateUrl: basePath + 'sucursal.create.html'
                    }
                }

            }).state('sucursalEdit', {
                url: '/sucursal/:sucursalId',
                param: {
                    sucursalId: null
                },
                views: {
                    'mainView': {
                        controller: 'sucursalCtrl',
                        controllerAs: 'sucursalCtrl',
                        templateUrl: basePath + 'sucursal.create.html'
                    }
                }
            });
        }]);
})(window.angular);