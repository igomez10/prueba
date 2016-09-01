/* 
 * Modulo Cliente.
 */
(function(ng)
{
    var mod = ng.module("clienteModule",["ngMessages", "ui.router"] );
    mod.constant("clienteContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) 
        {
            var basePath = 'src/modules/cliente/';
            $urlRouterProvider.otherwise("/clienteList");
  
            $stateProvider.state('clienteList', 
            {
                url: '/clientes',
                views: 
                        {
                            'mainView': 
                            {
                                controller: 'clienteCtrl',
                                controllerAs: 'clienteCtrl',
                                templateUrl: basePath + 'cliente.list.html'
                            }
                        }
            }).state('clienteCreate', 
            {
                url: '/clientes/create',
                views: 
                {
                    'mainView': 
                    {
                        controller: 'clienteCtrl',
                        controllerAs: 'clienteCtrl',
                        templateUrl: basePath + 'cliente.create.html'
                    }
                }

            }).state('clienteEdit', 
            {
                url: '/clientes/:clienteId',
                param: 
                {
                    clienteId: null
                },
                views: 
                {
                    'mainView': 
                    {
                        controller: 'clienteCtrl',
                        controllerAs: 'clienteCtrl',
                        templateUrl: basePath + 'cliente.create.html'
                    }
                }
            });
        }]);
    
}
)(window.angular);


