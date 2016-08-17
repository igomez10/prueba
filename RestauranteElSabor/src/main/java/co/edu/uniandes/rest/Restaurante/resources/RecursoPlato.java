/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.Restaurante.resources;

import co.edu.uniandes.rest.Restaurante.dtos.PlatoDTO;
import co.edu.uniandes.rest.Restaurante.mocks.MockPlato;
import co.edu.uniandes.rest.cities.exceptions.LogicaRestauranteException;

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
 * @author zlcastaneda10
 */
@Path("platos")
@Produces("application/json")
@Consumes("application/json")
public class RecursoPlato 
{
    MockPlato mockPlato = new MockPlato();
    
    /**
     * Obtiene una lista con todos los platos.
     * @return lista de platos.
     * @throws LogicaRestauranteException Si no existe una lista de clientes en el sistema.
     */
    @GET
    public List<PlatoDTO> darPlatos() throws LogicaRestauranteException 
    {
        return mockPlato.darPlatos();
    }
    
     /**
     * Obtiene el cliente con el identificador buscado.
     * @param pId Identificador del cliente buscado
     * @return PlatoDTO Cliente buscado.
     * @throws LogicaRestauranteException Si no existe un cliente con el identificador dado.
     */
    @GET
    @Path("{id: \\d+}")
    public PlatoDTO darPlato(@PathParam("id") Long pId) throws LogicaRestauranteException 
    {
        return mockPlato.darPlato(pId);
    }
    
    
     /**
     * Crea una nueva instancia de Cliente.
     * @param pId Identificacion del cliente a crear.
     * @param pNombre Nombre del cliente a crear.
     * @param pApellidos Apellidos del cliente a crear.
     * @param pDireccion Direccion del cliente a crear.
     * @return PlatoDTO cliente creado.
     * @throws LogicaRestauranteException Si ya existe un cliente con ese id.
     */
    @POST
    public PlatoDTO crearPlato(PlatoDTO nuevoPlato) throws LogicaRestauranteException
    {
        return mockPlato.crearPlato(nuevoPlato);
    }
    
    /**
     *
     * @param PlatoDTO Cliente a actualizar.
     * @throws LogicaRestauranteException Si no existe un cliente con el id dado.
     */
    @PUT
    public PlatoDTO actualizarCliente(PlatoDTO platoActualizado) throws LogicaRestauranteException 
    {
        return mockPlato.actualizarPlato(platoActualizado);
    }
    
    /**
     * Elimina el plato con el identificador indicado
     * @param pId Identificador del cliente que se quiere eliminar.
     * @throws LogicaRestauranteException Si no existe ningun cliente con el id dado.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void eliminarCliente(@PathParam("id") Long pId) throws LogicaRestauranteException 
    {
        mockPlato.eliminarPlato(pId);
    }
}
