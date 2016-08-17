/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author aj.paredes10
 */

@Path("reservas")
@Produces("application/json")
public class RecursoReserva {
    
    MockReserva mockReserva = new MockReserva();
    
    @GET
    public List<ReservaDTO> getReservas() throws LogicaRestauranteException {
        return mockReserva.getReservas();
    }
    
    @POST
    public ReservaDTO createReserva(ReservaDTO reserva) throws LogicaRestauranteException {
        return mockReserva.createReserva(reserva);
    }
    @GET
    @Path ("{id: \\d+}")
    public ReservaDTO getReserva (@PathParam ("id")Long id) throws LogicaRestauranteException {
     return mockReserva.getReserva(id);
    }   
   
    @PUT
    @Path ("{id: \\d+}")
    public ReservaDTO uptadeReserva (ReservaDTO reserva) throws LogicaRestauranteException {
     return mockReserva.updateReserva(reserva);
    }
    
    @DELETE
    @Path ("{id: \\d+}")
    public void deleteReserva (@PathParam ("id")Long id) throws LogicaRestauranteException {
       mockReserva.deleteReserva(id);
    } 
    
}
