/* 
 * Controlador Cliente.
 */
(function(ng)
{
    var mod = ng.module("clienteModule");
    
    mod.controller("clienteCtrl", ['$scope', '$state', '$stateParams', '$http', 'platoContext', function ($scope, $state, $stateParams, $http, context) 
    {
        $scope.records = {};                            // La lista de clientes no contiene ninguno.
        
        $http.get(context).then(function(response)      // Obtiene los clientes del sistema GET.
        {
            $scope.records = response.data;    
        }, responseError);
        
        if ($stateParams.idCliente !== null && $stateParams.idCliente !== undefined) 
        {
                id = $stateParams.clienteId;              // Toma el parametro id.
                
                $http.get(context + "/" + id)             // Obtiene el dato del recurso REST
                    .then(function (response) 
                    {  
                        $scope.currentRecord = response.data;    // Comando para actualizar el reccord que llega.
                    }, responseError);
        } 
        else
        {
            // Ajusta el record actual como un default.
            $scope.currentRecord = 
            {
                id: undefined,
                nombre: 's',
                precio: undefined,
                descripcion: 'ss'
            };
             
            $scope.alerts = [];
        }
        
        this.saveRecord = function (id, nombre, precio, descripcion) 
        {
            currentRecord = $scope.currentRecord;        
            
            if (id != null) 
            {
                // ejecuta POST en el recurso REST
                return $http.post(context, currentRecord)
                        .then(function () 
                        {
                            $state.go('clienteList');
                        }, responseError);
            } 
        }
    }]);

})(window.angular);
    
    