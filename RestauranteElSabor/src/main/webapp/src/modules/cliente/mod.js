var mod = angular.module("clienteModule", ['ui.router']);						// El modulo
	
	mod.config(['$stateProvider', '$urlRouterProvider', 
	function($stateProvider, $urlRouterProvider)
	{
		var basePath = "src/modules/clientes";									// La ruta del modulo
		$urlRouterProvider.otherWiste("/clientes");	
		
		$stateProvider.state('clientes',										// Este estado configura la url y el templateURl que el archivo que contiene los links hacia los otros estador. No es necesario controlador.
		{
			url: "/clientes",
			templateUrl: basePath+"clientes.html"
		}
                )
		.state('clientes.mostrar',												// En este estado se muestran los clientes.
		{
			url: "mostrar",
			templateUrl: basePath+"mostrarClientes.html",
			controller: function($scope)
                        {
				$scope.clientes = [];
			}
                }
		);
	}
	]
	)
	