(function (ng) {
    var mod = ng.module("domiciliosModule", ["ngMessages", "ui.router"]);
    mod.constant("domicilioContext", "api/domicilios");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/domicilios/';
            $urlRouterProvider.otherwise("/domiciliosList");

            $stateProvider.state('domiciliosList', {
                url: '/domicilios',
                views: {
                    'mainView': {
                        controller: 'domiciliosCtrl',
                        controllerAs: 'domiciliosCtrl',
                        templateUrl: basePath + 'domicilios.list.html'
                    }
                }
            }).state('domiciliosCreate', {
                url: '/domicilios/create',
                views: {
                    'mainView': {
                        controller: 'domiciliosCtrl',
                        controllerAs: 'domiciliosCtrl',
                        templateUrl: basePath + 'domicilios.create.html'
                    }
                }

            }).state('domicilioEdit', {
                url: '/domicilios/:domicilioId',
                param: {
                    domicilioId: null
                },
                views: {
                    'mainView': {
                        controller: 'domiciliosCtrl',
                        controllerAs: 'domiciliosCtrl',
                        templateUrl: basePath + 'domicilios.create.html'
                    }
                }
            });
        }]);
})(window.angular);
