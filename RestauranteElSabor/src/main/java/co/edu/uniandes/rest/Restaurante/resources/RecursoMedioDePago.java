/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.resources;

import co.edu.uniandes.rest.Restaurante.dtos.MedioDePagoDTO;
import co.edu.uniandes.rest.Restaurante.exceptions.LogicaRestauranteException;
import co.edu.uniandes.rest.Restaurante.mocks.MockMedioDePago;
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
 * @author igomez10
 */
@Path("mediodepago")
@Produces("application/json")
@Consumes("application/json")
public class RecursoMedioDePago
{
    MockMedioDePago mockMedioDePago = new MockMedioDePago();

    /**
     * Obtiene una lista con todos los medios de pago.
     * @return lista de medios de pago.
     * @throws LogicaRestauranteException Si no existe una lista de medios de pago en el sistema.
     */
    @GET
    public List<MedioDePagoDTO> darMediosDePago() throws LogicaRestauranteException
    {
        return mockMedioDePago.darMediosDePago();
    }

     /**
     * Obtiene el medio de pago con el identificador buscado.
     * @param pId Identificador del medio de pago buscado
     * @return MedioDePagoDTO medio de pago buscado.
     * @throws LogicaRestauranteException Si no existe un medio de pago con el identificador dado.
     */
    @GET
    @Path("{id: \\d+}")
      public MedioDePagoDTO darMedioDePago(@PathParam("id") Integer pId) throws LogicaRestauranteException
    {
        return mockMedioDePago.darMedioDePago(pId);
    }


     /**
     * Crea una nueva instancia de MedioDePago.
     * @return ClienteDTO cliente creado.
     * @throws LogicaRestauranteException Si ya existe un cliente con ese id.
     */
    @POST
    public ClienteDTO crearMedioDePago(MedioDePagoDTO nuevoMedioDePago) throws LogicaRestauranteException
    {
        return mockMedioDePago.crearMedioDePago(nuevoMedioDePago);
    }

    /**
     *
     * @param MedioDePagoDTO medio de pago a actualizar.
     * @throws LogicaRestauranteException Si no existe un medio de pago con el id dado.
     */
    @PUT
    public MedioDePagoDTO actualizarMedioDePago(MedioDePagoDTO medioDePagoActualizado) throws LogicaRestauranteException
    {
        return mockMedioDePago.actualizarMedioDePago(medioDePagoActualizado);
    }

    /**
     * Elimina el medio de pago con el identificador indicado
     * @param pId Identificador del medio de pago que se quiere eliminar.
     * @throws LogicaRestauranteException Si no existe ningun medio de pago con el id dado.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void eliminarMedioDePago(@PathParam("id") Integer pId) throws LogicaRestauranteException
    {
        mockMedioDePago.eliminarMedioDePago(pId);
    }
}
