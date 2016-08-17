/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.Restaurante.resources;

import co.edu.uniandes.rest.Restaurante.dtos.DomicilioDTO;
import co.edu.uniandes.rest.cities.exceptions.LogicaRestauranteException;
import co.edu.uniandes.rest.Restaurante.mocks.MockDomicilios;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("Domicilios")
@Produces("application/json")
@Consumes("application/json")
public class RecursoDomicilio 
{
    MockDomicilios mockDomicilio = new MockDomicilios();
   
    @GET
    public List<DomicilioDTO> getDomicilios() throws LogicaRestauranteException 
    {
        return mockDomicilio.getDomicilios();
    }
   @POST
    public DomicilioDTO createDomicilio(DomicilioDTO domi) throws LogicaRestauranteException {
        return mockDomicilio.createDomicilio(domi);
    }
    @GET
    @Path ("{id: \\d+}")
    public DomicilioDTO getDomicilio (@PathParam ("id")Long id) throws LogicaRestauranteException {
     return mockDomicilio.getDomicilio(id);
    }   
   
    @PUT
    @Path ("{id: \\d+}")
    public DomicilioDTO uptadeDomicilio (DomicilioDTO domi) throws LogicaRestauranteException {
     return mockDomicilio.updateDomicilio(domi);
    }
    
    @DELETE
    @Path ("{id: \\d+}")
    public void deleteDomicilio (@PathParam ("id")Long id) throws LogicaRestauranteException {
       mockDomicilio.deleteDomicilio(id);
    } 
}
