/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.resources;

import co.edu.uniandes.rest.cities.dtos.ClienteDTO;
import co.edu.uniandes.rest.cities.exceptions.LogicaRestauranteException;
import co.edu.uniandes.rest.cities.mocks.MockClientes;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author jdguz
 */
@Path("clientes")
@Produces("application/json")
public class RecursoCliente 
{
    MockClientes mockClientes = new MockClientes();
    
    /**
     * Obtiene una lista con todos los clientes.
     * @return lista de clientes.
     * @throws LogicaRestauranteException Si no existe una lista de clientes en el sistema.
     */
    @GET
    public List<ClienteDTO> darClientes() throws LogicaRestauranteException 
    {
        return mockClientes.darClientes();
    }
    
     /**
     * Obtiene el cliente con el identificador buscado.
     * @PathParam id Identificador del cliente buscado
     * @return ClienteDTO Cliente buscado.
     * @throws LogicaRestauranteException Si no existe un cliente con el identificador dado.
     */
    @GET
    @Path("{id: \\d+}")
    public ClienteDTO darCliente(@PathParam("id") Long pId) throws LogicaRestauranteException 
    {
        return mockClientes.darCliente(pId);
    }
    
    
     /**
     * Crea una nueva instancia de Cliente.
     * @param pId Identificacion del cliente a crear.
     * @param pNombre Nombre del cliente a crear.
     * @param pApellidos Apellidos del cliente a crear.
     * @param pDireccion Direccion del cliente a crear.
     * @return ClienteDTO cliente creado.
     * @throws LogicaRestauranteException Si ya existe un cliente con ese id.
     */
 //   @POST
 //   public ClienteDTO crearCliente(Long pId, String pNombre, String pApellidos, String pDireccion) throws LogicaRestauranteException
 //   {
 //       return mockClientes.crearCliente(pId, pNombre, pApellidos, pDireccion);
 //   }
    
    /**
     *
     * @param cliente
     * @param pId Identificacion del cliente a actualizar.
     * @param pNombre Nombre del cliente a actualizar.
     * @param pApellidos Apellidos del cliente a actualizar.
     * @param pDireccion Direccion del cliente a actualizar.
     * @return ClienteDTO Cliente actualizado.
     * @throws LogicaRestauranteException Si no existe un cliente con el id dado.
     */
//    @PUT
//    public ClienteDTO actualizarCliente(Long pId, String pNombre, String pApellidos, String pDireccion) throws LogicaRestauranteException 
//    {
//        return mockClientes.actualizarCliente(pId, pNombre, pApellidos, pDireccion);
//    }
    
    /**
     * Elimina el cliente con el identificador indicado
     * @pathParam id Identificador del cliente que se quiere eliminar.
     * @throws LogicaRestauranteException Si no existe ningun cliente con el id dado.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void eliminarCliente(@PathParam("id") Long pId) throws LogicaRestauranteException 
    {
        mockClientes.eliminarCliente(pId);
    }
}
