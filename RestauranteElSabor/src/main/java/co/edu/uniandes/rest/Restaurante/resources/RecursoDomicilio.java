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

/**
 *
 * @author cc.novoa11
 */

@Path("domicilios")
@Produces("application/json")
@Consumes("application/json")
public class RecursoDomicilio 
{
    MockDomicilios mockDomicilio = new MockDomicilios();
    
    /**
     * Retorna la lista de domicilios.
     * @return lista de domicilios.
     * @throws LogicaRestauranteException Si no existe una lista de domicilios en el sistema.
     */
   
    @GET
    public List<DomicilioDTO> getDomicilios() throws LogicaRestauranteException 
    {
        return mockDomicilio.getDomicilios();
    }
   
    /**
     * Obtiene el domicilio con el identificador buscado.
     * @param id Identificador del domicilio buscado.
     * @return DomicilioDTO domicilio buscado.
     * @throws LogicaRestauranteException Si no existe un domicilio con el identificador dado.
     */
    @GET
    @Path ("{id: \\d+}")
    public DomicilioDTO getDomicilio (@PathParam ("id")Long id) throws LogicaRestauranteException 
    {
     return mockDomicilio.getDomicilio(id);
    }   
    
    /**
     * Crea un domicilio con la información enviada como parámetro.
     * @param domi La instancia domicilio que se quiere crear.
     * @return DomicilioDTO domicilio creado.
     * @throws LogicaRestauranteException Si ya existe un domicilio con ese id.
     */
   @POST
    public DomicilioDTO createDomicilio(DomicilioDTO domi) throws LogicaRestauranteException
    {
        return mockDomicilio.createDomicilio(domi);
    }
 
    /**
     * Actualiza un domicilio con la información enviada como parámetro.
     * @param DomicilioDTO domi La instancia domicilio que se quiere actualizar.
     * @throws LogicaRestauranteException Si ya existe un domicilio con ese id.
     */
   
    @PUT
    @Path ("{id: \\d+}")
    public DomicilioDTO uptadeDomicilio (DomicilioDTO domi) throws LogicaRestauranteException 
    {
     return mockDomicilio.updateDomicilio(domi);
    }
    
     /**
     * Elimina un domicilio con la información enviada como parámetro.
     * @param DomicilioDTO domi La instancia domicilio que se quiere eliminar.
     * @throws LogicaRestauranteException Si ya existe un domicilio con ese id.
     */
    
    @DELETE
    @Path ("{id: \\d+}")
    public void deleteDomicilio (@PathParam ("id")Long id) throws LogicaRestauranteException {
       mockDomicilio.deleteDomicilio(id);
    } 
}
