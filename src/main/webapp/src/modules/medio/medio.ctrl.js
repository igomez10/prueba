(function (ng) {

    var mod = ng.module("medioModule");

    mod.controller("medioCtrl", ['$scope', '$state', '$stateParams', '$http', 'medioContext', function ($scope, $state, $stateParams, $http, context) {

            // inicialmente el listado de medio está vacio
            $scope.records = {};
            // carga los medios de pago
            $http.get(context).then(function (response) {
                $scope.records = response.data;
            }, responseError);

            // el controlador recibió un medioId ??
            // revisa los parámetros (ver el :medioId en la definición de la ruta)
            if ($stateParams.medioId !== null && $stateParams.medioId !== undefined) {
                // toma el id del parámetro
                id = $stateParams.medioId;
                // obtiene el dato del recurso REST
                $http.get(context + "/" + id)
                        .then(function (response) {
                            // $http.get es una promesa
                            // cuando llegue el dato, actualice currentRecord
                            $scope.currentRecord = response.data;
                        }, responseError);

                // el controlador no recibió un medioId
            } else
            {
                // el registro actual debe estar vacio
                $scope.currentRecord = {
                    id: undefined               /*Tipo Long. El valor se asigna en el backend*/,
                    efectivo: undefined         /*Tipo boolean*/,
                    tarjeta: ''                 /*Tipo String*/,
                    numerosTarjeta: undefined   /*Tipo Long*/,
                    fechaVencimiento: undefined /*Tipo Date*/,
                    codigoSeguridad: undefined  /*Tipo Integer*/,
                    franquicia: undefined       /*Tipo String*/
                };

                $scope.alerts = [];
            }

            this.saveRecord = function (id, efectivo, tarjeta, numerosTarjeta, fechaVencimiento, codigoSeguridad, franquicia) {
                currentRecord = $scope.currentRecord;
                // si el id es null, es un registro nuevo, entonces lo crea
                if (id == null) {
                    // ejecuta POST en el recurso REST
                    return $http.post(context, currentRecord)
                            .then(function () {
                                // $http.post es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('medioList');
                            }, responseError);
                    // si el id no es null, es un registro existente entonces lo actualiza
                } else {

                    // ejecuta PUT en el recurso REST
                    return $http.put(context + "/" + currentRecord.id, currentRecord)
                            .then(function () {
                                // $http.put es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('medioList');
                            }, responseError);
                }
                ;
            };

            this.deleteRecord = function (id) {
                currentRecord = $scope.currentRecord;
                $http.delete(context + "/" + currentRecord.id)
                        .then(function () {
                            // $http.put es una promesa
                            // cuando termine bien, cambie de estado
                            $state.go('medioList');
                        }, responseError);

            };


            // -----------------------------------------------------------------
            // Funciones para manejra los mensajes en la aplicación
            //Alertas
            this.closeAlert = function (index) {
                $scope.alerts.splice(index, 1);
            };

            // Función showMessage: Recibe el mensaje en String y su tipo con el fin de almacenarlo en el array $scope.alerts.
            function showMessage(msg, type) {
                var types = ["info", "danger", "warning", "success"];
                if (types.some(function (rc) {
                    return type === rc;
                })) {
                    $scope.alerts.push({type: type, msg: msg});
                }
            }

            this.showError = function (msg) {
                showMessage(msg, "danger");
            };

            this.showSuccess = function (msg) {
                showMessage(msg, "success");
            };

            var self = this;
            function responseError(response) {

                self.showError(response.data);
            }
        }]);

})(window.angular);