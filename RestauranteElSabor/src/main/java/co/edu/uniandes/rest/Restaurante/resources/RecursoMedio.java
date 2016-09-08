/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.Restaurante.resources;

import co.edu.uniandes.rest.Restaurante.dtos.MedioDTO;
import co.edu.uniandes.rest.cities.exceptions.LogicaRestauranteException;
import co.edu.uniandes.rest.Restaurante.mocks.MockMedio;
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
@Path("medios")
@Produces("application/json")
@Consumes("application/json")
public class RecursoMedio
    {
        MockMedio mockMedio = new MockMedio();
        

    /**
     * Obtiene una lista con todos los medios de pago.
     * @return lista de medios de pago.
     * @throws LogicaRestauranteException Si no existe una lista de medios de pago en el sistema.
     */
    @GET
    public List<MedioDTO> darMedios() throws LogicaRestauranteException
    {
        return mockMedio.darMedios();
    }

     /**
     * Obtiene el medio de pago con el identificador buscado.
     * @param pId Identificador del medio de pago buscado
     * @return MedioDTO medio de pago buscado.
     * @throws LogicaRestauranteException Si no existe un medio de pago con el identificador dado.
     */
    @GET
    @Path("{id: \\d+}")
      public MedioDTO darMedio(@PathParam("id") Integer pId) throws LogicaRestauranteException
    {
        return mockMedio.darMedio(pId);
    }


     /**
     * Crea una nueva instancia de Medio.
     * @return medioDTO medio de pago creado.
     * @throws LogicaRestauranteException Si ya existe un medio de pago con ese id.
     */
    @POST
    public MedioDTO crearMedio(MedioDTO nuevoMedio) throws LogicaRestauranteException
    {
        return mockMedio.crearMedio(nuevoMedio);
    }

    /**
     *
     * @param MedioDTO medio de pago a actualizar.
     * @throws LogicaRestauranteException Si no existe un medio de pago con el id dado.
     */
    @PUT
    public MedioDTO actualizarMedio(MedioDTO medioActualizado) throws LogicaRestauranteException
    {
        return mockMedio.actualizarMedio(medioActualizado);
    }

    /**
     * Elimina el medio de pago con el identificador indicado
     * @param pId Identificador del medio de pago que se quiere eliminar.
     * @throws LogicaRestauranteException Si no existe ningun medio de pago con el id dado.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void eliminarMedio(@PathParam("id") Integer pId) throws LogicaRestauranteException
    {
        mockMedio.eliminarMedio(pId);
    }
}
