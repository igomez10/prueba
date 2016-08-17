
package co.edu.uniandes.rest.Restaurante.mocks;

import co.edu.uniandes.rest.Restaurante.dtos.DomicilioDTO;
import co.edu.uniandes.rest.cities.exceptions.LogicaRestauranteException;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aj.paredes10
 */
public class MockDomicilios {
    
    private final static Logger logger = Logger.getLogger(MockDomicilios.class.getName());
    
    private static ArrayList<DomicilioDTO> domicilios;
    
    public MockDomicilios() {
        
        if (domicilios == null) {
            domicilios = new ArrayList<>();
            domicilios.add(new DomicilioDTO(1L, "Direccion1", "Plato 1", 10000));
            domicilios.add(new DomicilioDTO(2L, "Direccion2", "Plato 2", 15000));
            domicilios.add(new DomicilioDTO(3L, "Direccion3", "Plato 3", 12000));

        }
        
        // indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// muestra información 
    	logger.info("Inicializa la lista de domicilios");
    	logger.info("domicilios" + domicilios );
    }
    /**
     *
     * @return
     * @throws LogicaRestauranteException
     */
    public List<DomicilioDTO> getDomicilios() throws LogicaRestauranteException {
    	if (domicilios == null) {
    		logger.severe("Error interno: lista de domicilios no se encuentra.");
    		throw new LogicaRestauranteException("Error interno: lista de domicilios no se encuentra.");    		
    	}
    	
    	logger.info("retornando todos los domicilios");
    	return domicilios;
    }
    
    public DomicilioDTO getDomicilio(Long id) throws LogicaRestauranteException{
     
          for (DomicilioDTO domi : domicilios) {

	            if (Objects.equals(domi.getId(), id)){
                         return domi;
                    }
        }
        logger.severe("Error interno: domicilio no existe.");
    		throw new LogicaRestauranteException("Error interno: domicilio no existe.");
    }
    
    public DomicilioDTO createDomicilio(DomicilioDTO nDomicilio) throws LogicaRestauranteException {
    	logger.info("recibiendo solicitud de agregar un domicilio " + nDomicilio);
    	
       	if ( nDomicilio.getId() != null ) {
	    	for (DomicilioDTO domi : domicilios) {
	            if (Objects.equals(domi.getId(), nDomicilio.getId())){
	            	logger.severe("Ya existe una domicilio con ese id");
	                throw new LogicaRestauranteException("Ya existe una domicilio con ese id");
	            }
	        }
	        
    	} else {
    		logger.info("Generando id para un nuevo domicilio");
    		long newId = 1;
	        for (DomicilioDTO domi : domicilios) {
	            if (newId <= domi.getId()){
	                newId =  domi.getId() + 1;
	            }
	        }
	        nDomicilio.setId(newId);
    	}
    	
    	logger.info("agregando domicilio " + nDomicilio);
        domicilios.add(nDomicilio);
        return nDomicilio;
    }
    
    public DomicilioDTO updateDomicilio(DomicilioDTO domicilio) throws LogicaRestauranteException{
       for (DomicilioDTO domi : domicilios) {

	    if (Objects.equals(domi.getId(), domicilio.getId())){
                domi.setDir(domicilio.getDir());
                domi.setPlato(domicilio.getPlato());
                domi.setPrecio(domicilio.getPrecio());
                return domi;
            }
        }
       logger.severe("Error interno: El domicilio no existe.");
    		throw new LogicaRestauranteException("Error interno: El domicilio no existe.");
   }
    
    public void deleteDomicilio(Long id) throws LogicaRestauranteException
    {
        boolean eliminado = false;
        
         for (int i = 0; i< domicilios.size() && !eliminado; i++) 
         {
             DomicilioDTO domi = domicilios.get(i);
             if(domi.getId().equals(id))
             {
                 domicilios.remove(i);
                 eliminado = true;
        }
         }
        
         if(!eliminado)
         {
         logger.severe("Error de uso: Se pidio eliminar un domicilio con id "+id+" que no existe.");
         throw new LogicaRestauranteException("Error de uso: Se pidio eliminar un domicilio con id "+id+" que no existe.");
         }
    }
   
}
