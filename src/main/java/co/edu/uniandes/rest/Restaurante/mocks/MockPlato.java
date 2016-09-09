package co.edu.uniandes.rest.Restaurante.mocks;

import co.edu.uniandes.rest.Restaurante.dtos.PlatoDTO;
import co.edu.uniandes.rest.cities.exceptions.LogicaRestauranteException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * CityLogicMock
 * Mock del recurso Ciudades (Mock del servicio REST)
 */

public class MockPlato 
{	
    // Objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(MockClientes.class.getName());
	
    // Arreglo de platos.
    private static ArrayList<PlatoDTO> platos;

    
    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public MockPlato() 
    {
    	if (platos == null) 
        {
            platos = new ArrayList<PlatoDTO>();
            platos.add(new PlatoDTO(1L, "Plato1", 10000, "Sopa"));
            platos.add(new PlatoDTO(2L, "Plato2", 15000, "Bandeja paisa"));
            platos.add(new PlatoDTO(3L, "Plato3", 8000, "Corrientazo"));
            platos.add(new PlatoDTO(4L, "Plato4", 20000, "Pescado"));
        }
        
    	// Indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// Muestra información 
    	logger.info("Inicializada la lista de platos");
    	logger.info("Platos:\n" + platos );
    }    
    
    /**
    * Obtiene el listado de platos. 
    * @return Lista de platos
    * @throws LogicaRestauranteException cuando no existe la lista en memoria  
    */    
    public List<PlatoDTO> darPlatos() throws LogicaRestauranteException 
    {
        logger.info("Recibiendo solicitud de dar todos los platos.");
        
    	if (platos == null) 
        {
    		logger.severe("Error interno: lista de platos no existe.");
    		throw new LogicaRestauranteException("Error interno: lista de platos no existe.");    		
    	}
        
    	logger.info("Retornando todos los platos.");
    	return platos;
    }
    
    /**
    * Obtiene el plato con el id que entra por parametro. 
    * @return PlatoDTO Plato buscado.
    * @throws LogicaRestauranteException Cuando no existe un plato con el id buscado.  
    */    
    public PlatoDTO darPlato(Long pId) throws LogicaRestauranteException 
    {
        logger.info("Recibiendo solicitud de dar el cliente con id "+pId+".");
        
    	if (platos == null) 
        {
    		logger.severe("Error interno: lista de platos no existe.");
    		throw new LogicaRestauranteException("Error interno: lista de platos no existe.");    		
    	}
        
        for(PlatoDTO plato:platos)
        {
            if(plato.getId().equals(pId))
            {
                logger.info("Retornando el plato con id "+pId);
                return plato;
            }
        }
    	logger.severe("Error de uso: Se pidio un plato que no existe.");
    	throw new LogicaRestauranteException("Error de uso: Se pidio un plato que no existe.");
    }

    /**
     * Agrega un plato al sistema.
     * @param nuevoPlato Plato a agregar.
     * @return plato agregado.
     */
    public PlatoDTO crearPlato(PlatoDTO nuevoPlato) throws LogicaRestauranteException
    {
    	logger.info("Recibiendo solicitud de agregar un plato.");
        Long idPlatoAgregar = nuevoPlato.getId();
        
    	// Se busca que no exista un cliente con ese id.
	for (PlatoDTO plato : platos) 
        {
            if(plato.getId().equals(idPlatoAgregar))
            {
                logger.severe("Error de uso: Se intento crear un plato con un id "+idPlatoAgregar+" que ya existia.");
                throw new LogicaRestauranteException("Error de uso: Se intento crear un plato con un id "+idPlatoAgregar+" que ya existia.");
            }
	}
	
        // Se Agrega el cliente.
    	logger.info("Agregando Plato: " + nuevoPlato);
        platos.add(nuevoPlato);
        return nuevoPlato;
    }

  public PlatoDTO actualizarPlato(Long id, PlatoDTO platoAct) throws LogicaRestauranteException
   {   
       logger.info("Recibiendo solicitud de actualizar plato."+ platoAct); 
       
       
       // Se busca el cliente a actualizar
        for (PlatoDTO plato : platos) 
        {
             if (Objects.equals(plato.getId(), id)) {

                // modifica la ciudad
                plato.setId(platoAct.getId());
                plato.setNombre(platoAct.getNombre());
                plato.setDescripcion(platoAct.getDescripcion());
                plato.setPrecio(platoAct.getPrecio());

                // retorna el plato modificado
                logger.info("Modificando plato " + plato);
                return plato;
            }
	}
       
      // Si se llega hasta aca es porque no se encontro plato con el id buscado.
        logger.severe("Error de uso: Se pidio actualizar un plato que no existe.");
        throw new LogicaRestauranteException("Error de uso: Se pidio actualizar un plato que no existe.");
   }
   
      public void eliminarPlato(Long pId) throws LogicaRestauranteException
   {
        logger.info("recibiendo solictud de eliminar plato con id " + pId);
       
         for (PlatoDTO plato : platos) {
            if (Objects.equals(plato.getId(), pId)) {

                // elimina la ciudad
                logger.info("eliminando plato " + plato);
                platos.remove(plato);
                return;
            }
        }

        // Si se llega hasta aca es porque no se encontro plato con el id buscado.
        logger.severe("Error de uso: Se pidio eliminar un plato con id "+pId+" que no existe.");
        throw new LogicaRestauranteException("Error de uso: Se pidio eliminar un plato con id "+pId+" que no existe.");
        
   }
}
