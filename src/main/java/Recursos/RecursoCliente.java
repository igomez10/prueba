/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import DTOs.ClienteDTO;
import Excepciones.LogicaRestauranteException;
import Mocks.MockClientes;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
     * Obtiene el listado de clientes.
     *
     * @return lista de ciudades
     * @throws CityLogicException excepción retornada por la lógica
     */
    @GET
    public List<ClienteDTO> darClientes() throws LogicaRestauranteException 
    {
        return mockClientes.darClientes();
    }
    
     /**
     * Agrega una cliente
     * @param cliente ciudad a agregar
     * @return datos de la ciudad a agregar
     * @throws CityLogicException cuando ya existe una ciudad con el id
     * suministrado
     */
    @POST
    public ClienteDTO createCity(ClienteDTO cliente) throws LogicaRestauranteException 
    {
        return mockClientes.crearCliente(cliente);
    }
}
