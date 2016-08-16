package co.edu.uniandes.rest.cities.mocks;

/**
 * Mock del recurso Ciudades (Mock del servicio REST)
 * @author Asistente
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;



import co.edu.uniandes.rest.cities.dtos.CityDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;

/*
 * CityLogicMock
 * Mock del recurso Ciudades (Mock del servicio REST)
 */

public class CityLogicMock {
	
	// objeto para presentar logs de las operaciones
	private final static Logger logger = Logger.getLogger(CityLogicMock.class.getName());
	
	// listado de ciudades
    private static ArrayList<CityDTO> cities;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public CityLogicMock() {

    	if (cities == null) {
            cities = new ArrayList<>();
            cities.add(new CityDTO(1L, "Bogota"));
            cities.add(new CityDTO(2L, "Cali"));
            cities.add(new CityDTO(3L, "Medellin"));
        }
        
    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// muestra información 
    	logger.info("Inicializa la lista de ciudades");
    	logger.info("ciudades" + cities );
    }    
    
	/**
	 * Obtiene el listado de personas. 
	 * @return lista de ciudades
	 * @throws CityLogicException cuando no existe la lista en memoria  
	 */    
    public List<CityDTO> getCities() throws CityLogicException {
    	if (cities == null) {
    		logger.severe("Error interno: lista de ciudades no existe.");
    		throw new CityLogicException("Error interno: lista de ciudades no existe.");    		
    	}
    	
    	logger.info("retornando todas las ciudades");
    	return cities;
    }

 

    /**
     * Agrega una ciudad a la lista.
     * @param newCity ciudad a adicionar
     * @throws CityLogicException cuando ya existe una ciudad con el id suministrado
     * @return ciudad agregada
     */
    public CityDTO createCity(CityDTO newCity) throws CityLogicException {
    	logger.info("recibiendo solicitud de agregar ciudad " + newCity);
    	
    	// la nueva ciudad tiene id ?
    	if ( newCity.getId() != null ) {
	    	// busca la ciudad con el id suministrado
	        for (CityDTO city : cities) {
	        	// si existe una ciudad con ese id
	            if (Objects.equals(city.getId(), newCity.getId())){
	            	logger.severe("Ya existe una ciudad con ese id");
	                throw new CityLogicException("Ya existe una ciudad con ese id");
	            }
	        }
	        
	    // la nueva ciudad no tiene id ? 
    	} else {

    		// genera un id para la ciudad
    		logger.info("Generando id paa la nueva ciudad");
    		long newId = 1;
	        for (CityDTO city : cities) {
	            if (newId <= city.getId()){
	                newId =  city.getId() + 1;
	            }
	        }
	        newCity.setId(newId);
    	}
    	
        // agrega la ciudad
    	logger.info("agregando ciudad " + newCity);
        cities.add(newCity);
        return newCity;
    }

   
}
