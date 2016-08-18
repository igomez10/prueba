/*
 * RecursoReserva.java
 * Clase que representa el recurso "/reservas"
 * Implementa varios métodos para manipular las reservas del restaurante
 */
package co.edu.uniandes.rest.Restaurante.resources;

import DTOs.ReservaDTO;
import co.edu.uniandes.rest.cities.exceptions.LogicaRestauranteException;
import co.edu.uniandes.rest.Restaurante.mocks.MockReserva;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *Clase que implementa el recurso REST correspondiente a "reservas".
 *
 * Este recurso tiene la ruta "reservas". Al ejecutar la aplicación, el recurse
 * será accesibe a través de la ruta "/api/reservas"
 * @author aj.paredes10
 */

@Path("reservas")
@Produces("application/json")
public class RecursoReserva {
    
    MockReserva mockReserva = new MockReserva();
    /**
     * Obtiene el listado de reservas.
     *
     * @return lista de reservas
     * @throws LogicaRestauranteException excepción retornada por la lógica
     */
    @GET
    public List<ReservaDTO> getReservas() throws LogicaRestauranteException {
        return mockReserva.getReservas();
    }
    /**
     * Crea una reserva.
     * @param reserva
     * @return datos de la reserva agragada
     * @throws LogicaRestauranteException si la reserva ya existe.
     */
    @POST
    public ReservaDTO createReserva(ReservaDTO reserva) throws LogicaRestauranteException {
        return mockReserva.createReserva(reserva);
    }
    /**
     * Obtiene una reserva.
     * @param id de la reserva a busccar
     * @return la reserva can el id solicitado
     * @throws LogicaRestauranteException en caso de no encontrar la rweserva buscada
     */
    @GET
    @Path ("{id: \\d+}")
    public ReservaDTO getReserva (@PathParam ("id")Long id) throws LogicaRestauranteException {
     return mockReserva.getReserva(id);
    }   
    /**
     * Acrualiza los datos de una reserva.
     * @param reserva a con los datos a modificar.
     * @return la reserva con los datos ya actualizados.
     * @throws LogicaRestauranteException si no encuentra la reserva a modificar.
     */
    
    @PUT
    @Path ("{id: \\d+}")
    public ReservaDTO uptadeReserva (ReservaDTO reserva) throws LogicaRestauranteException {
     return mockReserva.updateReserva(reserva);
    }
    /**
     * Elimina una reserva
     * @param id de la reserva a eliminar.
     * @throws LogicaRestauranteException si la reserva no es encontrada.
     */
    @DELETE
    @Path ("{id: \\d+}")
    public void deleteReserva (@PathParam ("id")Long id) throws LogicaRestauranteException {
       mockReserva.deleteReserva(id);
    } 
    
}
