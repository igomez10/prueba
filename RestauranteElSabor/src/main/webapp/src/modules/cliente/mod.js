var mod = angular.module("clienteModule", ['ui.router']);						// El modulo
	
	mod.config(['$stateProvider', '$urlRouterProvider', 
	function($stateProvider, $urlRouterProvider)
	{
		var basePath = "src/modules/cliente";							// La ruta del modulo
		$urlRouterProvider.otherWise("/cliente");	
		
		$stateProvider.state('clientes',							// Este estado configura la url y el templateURl que el archivo que contiene los links hacia los otros estador.
		{                                                                                              
			url: "/clientes",
                        views: 
                        {
                            "": {templateUrl: basePath+"clientes.html"},
                            "view1@clientes": {templateUrl: basePath+"mostrar.html",                    // Este estado cuenta con una vista de los clientes de la franquicia.
                                controller: function ($scope) 
                                {
                                    $scope.clients = ["1", "1", "3"];
                                }
                            }
                        }
		}
                )
		.state('clientes.agregar',								// En este estado se agregan los clientes.
		{
			url: "agregar",
			templateUrl: basePath+"agregar.html",
			controller: function($scope)
                        {
				
			}
                }
		);
	}
	]
        )
	