/* 
 * Controlador Cliente.
 */
(function(ng)
{
    var mod = ng.module("clienteModule");
    
    mod.controller("clienteCtrl", ['$scope', '$state', '$stateParams', '$http', 'clienteContext', function ($scope, $state, $stateParams, $http, context) 
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
                nombre: '',
                precio: undefined,
                direccion: ''
            };
             
            $scope.alerts = [];
        }
        
        this.saveRecord = function () 
        {
            currentRecord = $scope.currentRecord;        
            
            // Por ahora solo agrega, no modifica
                // ejecuta POST en el recurso REST
                return $http.post(context, currentRecord).then(function() 
                        {
                            $state.go('clienteList');
                        }, responseError);
             
        };
        
        this.deleteRecord = function(id)
        {
            return $http.delete(context+"/"+ id).then(function() 
            {
                $state.reload();
            }, responseError);
        };
        
        this.editRecord = function()
        {
            currentRecord = $scope.currentRecord;
            id = $stateParams.clienteId;
            currentRecord.id = id;
            return $http.put(context, currentRecord).then(function() 
                    {
                        $state.go('clienteList');
                    }, responseError);
        }
        

     // -----------------------------------------------------------------
     // Funciones para manejra los mensajes en la aplicación


    //Alertas
    this.closeAlert = function (index) 
    {
        $scope.alerts.splice(index, 1);
    };

    // Función showMessage: Recibe el mensaje en String y su tipo con el fin de almacenarlo en el array $scope.alerts.
    function showMessage(msg, type) 
    {
        var types = ["info", "danger", "warning", "success"];
        if (types.some(function (rc) 
        {
            return type === rc;
        })) 
        {
            $scope.alerts.push({type: type, msg: msg});
        }
    }

    this.showError = function (msg) 
    {
        showMessage(msg, "danger");
    };

    this.showSuccess = function (msg) 
    {
        showMessage(msg, "success");
    };

    var self = this;
            
    function responseError(response)
    {
        self.showError(response.data);
            
    }
    
}]);

    

})(window.angular);
    
    