package co.edu.uniandes.rest.Restaurante.mocks;

import co.edu.uniandes.rest.Restaurante.dtos.MedioDePagoDTO;
import co.edu.uniandes.rest.cities.exceptions.LogicaRestauranteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * CityLogicMock
 * Mock del recurso Ciudades (Mock del servicio REST)
 */

public class MockMedioDePago
{
    // Objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(MockMedioDePago.class.getName());

    // Arreglo de clientes.
    private static ArrayList<MedioDePagoDTO> medios;


    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public MockMedioDePago() throws ParseException
    {
    	if (medios == null)
        {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            medios = new ArrayList<MedioDePagoDTO>();
            medios.add(new MedioDePagoDTO(1, false,"descripcion1", 1234567890 ,df.parse("02/07/2018"),123,"visa"));
            medios.add(new MedioDePagoDTO(2, false,"descripcion2",234567890,df.parse("07/11/2019"),234,"mastercard"));
            medios.add(new MedioDePagoDTO(3, false,"descripcion3",345678901,df.parse("07/01/2020"),345,"diners"));
            medios.add(new MedioDePagoDTO(4, false,"descripcion4",456789012,df.parse("01/01/2017"),456,"visa"));
        }

    	// Indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);

    	// Muestra información
    	logger.info("Inicializada la lista de medios de pago");
    	logger.info("Medios de pago:\n" + medios );
    }

    /**
    * Obtiene el listado de personas.
    * @return Lista de ciudades
    * @throws LogicaRestauranteException cuando no existe la lista en memoria
    */
    public List<MedioDePagoDTO> darMediosDePago() throws LogicaRestauranteException
    {
        logger.info("Recibiendo solicitud de dar todos los mediosDePago.");

    	if (medios == null)
        {
    		logger.severe("Error interno: lista de medios de pago no existe.");
    		throw new LogicaRestauranteException("Error interno: lista de medios de pago no existe.");
    	}

    	logger.info("Retornando todos los medios de pago.");
    	return medios;
    }

    /**
    * Obtiene el cliente con el id que entra por parametro.
    * @return ClienteDTO Cliente buscado.
    * @throws LogicaRestauranteException Cuando no existe un cliente con el id buscado.
    */
    public MedioDePagoDTO darMedioDePago(Integer pId) throws LogicaRestauranteException
    {
        logger.info("Recibiendo solicitud de dar el medio de pago con id "+pId+".");

    	if (medios == null)
        {
    		logger.severe("Error interno: lista de medios de pago no existe.");
    		throw new LogicaRestauranteException("Error interno: lista de medios no existe.");
    	}

        for(MedioDePagoDTO medio:medios)
        {
            if(medio.getId().equals(pId))
            {
                logger.info("Retornando el medio de pago con id "+pId);
                return medio;
            }
        }
    	logger.severe("Error de uso: Se pidio un medio de pago que no existe.");
    	throw new LogicaRestauranteException("Error de uso: Se pidio un medio de pago que no existe.");
    }

    /**
     * Agrega un medio de pago al sistema.
     * @param nuevoMedioDePago a agregar.
     * @return MedioDePago agregado.
     */
    public MedioDePagoDTO crearMedioDePago(MedioDePagoDTO nuevoMedioDePago) throws LogicaRestauranteException
    {
    	logger.info("Recibiendo solicitud de agregar medio de pago.");
        Integer idMedioDePagoAAgregar = nuevoMedioDePago.getId();

    	// Se busca que no exista un medio de pago con ese id.
	for (MedioDePagoDTO medio : medios)
        {
            if(medio.getId().equals(idMedioDePagoAAgregar))
            {
                logger.severe("Error de uso: Se intento crear un medio de pago con un id "+idMedioDePagoAAgregar+" que ya existia.");
                throw new LogicaRestauranteException("Error de uso: Se intento crear un medio de pago con un id "+idMedioDePagoAAgregar+" que ya existia.");
            }
	}

        // Se Agrega el cliente.
    	logger.info("Agregando medio de pago: " + nuevoMedioDePago);
        medios.add(nuevoMedioDePago);
        return nuevoMedioDePago;
    }

  public MedioDePagoDTO actualizarMedioDePago(MedioDePagoDTO medioDePagoActualizado) throws LogicaRestauranteException
   {
       logger.info("Recibiendo solicitud de actualizar medio de pago.");
       Integer id = medioDePagoActualizado.getId();

       // Se busca el medio de pago a actualizar
        for (MedioDePagoDTO medio : medios)
        {
            if(medio.getId().equals(id))
            {
                boolean efectivo=medioDePagoActualizado.getEfectivo();
                String tarjeta = medioDePagoActualizado.getTarjeta();
                Integer numerosTarjeta=medioDePagoActualizado.getNumerosTarjeta();
                Date fechaVencimiento=medioDePagoActualizado.getFechaVencimiento();
                Integer codigoSeguridad=medioDePagoActualizado.getCodigoSeguridad();
                String franquicia= medioDePagoActualizado.getFranquicia();

                if(tarjeta != null)
                {
                    medio.setTarjeta(tarjeta);
                }
                if(franquicia !=null )
                {
                    medio.setFranquicia(franquicia);
                }
                if(fechaVencimiento != null)
                {
                    medio.setFechaVencimiento(fechaVencimiento);
                }
                return medio;
            }
	}

      // Si se llega hasta aca es porque no se encontro medio con el id buscado.
        logger.severe("Error de uso: Se pidio actualizar un medio que no existe.");
        throw new LogicaRestauranteException("Error de uso: Se pidio actualizar un medio que no existe.");
   }

      public void eliminarMedioDePago(Integer pId) throws LogicaRestauranteException
   {
       boolean eliminado = false;

        // Se busca el medio a eliminar
        for (int i = 0; i< medios.size() && !eliminado; i++)
        {
            MedioDePagoDTO medio = medios.get(i);
            if(medio.getId().equals(pId))
            {
                medios.remove(i);
                eliminado = true;
            }
        }

        if(!eliminado)
        {
        // Si se llega hasta aca es porque no se encontro medio con el id buscado.
        logger.severe("Error de uso: Se pidio eliminar un medio con id "+pId+" que no existe.");
        throw new LogicaRestauranteException("Error de uso: Se pidio eliminar un medio con id "+pId+" que no existe.");
        }
   }
}
