(function(ng){
    var app = ng.module('restaurante',[
        'ui.router',
        'clienteModule',
        'domiciliosModule',
        'mediodepagoModule',
        'platoModule',
        'reservaModule',
        'sucursalModule',
        'ngMessages'
    ]);
    app.config(['$logProvider', function ($logProvider) {
            $logProvider.debugEnabled(true);
        }]);
    app.config(['$urlRouterProvider', function ($urlRouterProvider) {
            $urlRouterProvider.otherwise('/RestauranteElSabor');
        }]);
})(window.angular);