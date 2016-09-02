/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.Restaurante.resources;

import co.edu.uniandes.rest.Restaurante.dtos.SucursalDTO;
import co.edu.uniandes.rest.cities.exceptions.LogicaRestauranteException;
import co.edu.uniandes.rest.Restaurante.mocks.MockSucursales;
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
 * @author af.pinzon10
 */
@Path("sucursales")
@Produces("application/json")
@Consumes("application/json")
public class RecursoSucursal 
{
    MockSucursales mockSucursales = new MockSucursales();
    
    /**
     * Obtiene una lista con tados las sucursales.
     * @return lista de sucursales.
     * @throws LogicaRestauranteException Si no existe una lista de sucursales en el sistema.
     */
    @GET
    public List<SucursalDTO> darSucursales() throws LogicaRestauranteException 
    {
        return mockSucursales.darSucursales();
    }
    
     /**
     * Obtiene la sucursal con el identificador buscado.
     * @param pId Identificador de la sucursal buscada
     * @return SucursalDTO Sucursal buscada.
     * @throws LogicaRestauranteException Si no existe una sucursal con el identificador dado.
     */
    @GET
    @Path("{id: \\d+}")
    public SucursalDTO darSucursal(@PathParam("id") Long pId) throws LogicaRestauranteException 
    {
        return mockSucursales.darSucursal(pId);
    }
    
    
     /**
     * Crea una nueva instancia de Sucursal.
     * @param pId Identificacion de la sucursal a crear.
     * @param pCiudad Nombre de la sucursal a crear.
     * @param pDireccion Direccion del sucursal a crear.
     * @param pMesas Numero de mesas de la sucursal a crear.
     * @param pCalificacion Calificacion de la sucursal a crear.
     * @return SucursalDTO sucursal creada.
     * @throws LogicaRestauranteException Si ya existe un sucursal con ese id.
     */
    @POST
    public SucursalDTO crearSucursal(SucursalDTO nuevaSucursal) throws LogicaRestauranteException
    {
        return mockSucursales.crearSucursal(nuevaSucursal);
    }
    
    /**
     *
     * @param SucursalDTO Sucursal a actualizar.
     * @throws LogicaRestauranteException Si no existe una sucursal con el id dado.
     */
    @PUT
    public SucursalDTO actualizarSucursal(SucursalDTO sucursalActualizada) throws LogicaRestauranteException 
    {
        return mockSucursales.actualizarSucursal(sucursalActualizada);
    }
    
    /**
     * Elimina la sucursal con el identificador indicado
     * @param pId Identificador de la sucursal que se quiere eliminar.
     * @throws LogicaRestauranteException Si no existe ninguna sucursal con el id dado.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void eliminarSucursal(@PathParam("id") Long pId) throws LogicaRestauranteException 
    {
        mockSucursales.eliminarSucursal(pId);
    }
}
