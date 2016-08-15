package Mocks;

/**
 * Mock del recurso Ciudades (Mock del servicio REST)
 * @author Asistente
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


import DTOs.ClienteDTO;
import Excepciones.LogicaRestauranteException;

/*
 * CityLogicMock
 * Mock del recurso Ciudades (Mock del servicio REST)
 */

public class MockClientes 
{	
    // objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(MockClientes.class.getName());
	
	// arreglo de clientes
    private static ArrayList<ClienteDTO> clientes;

    // TODO: ACA SE PONEN LAS COLECCIONES DE LAS CLASES
    
    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public MockClientes() 
    {
    	if (clientes == null) 
        {
            clientes = new ArrayList<ClienteDTO>();
            clientes.add(new ClienteDTO(1L, "Nombre1", "Apellido1", "Direccion1"));
            clientes.add(new ClienteDTO(2L, "Nombre2", "Apellido2", "Direccion2"));
            clientes.add(new ClienteDTO(3L, "Nombre3", "Apellido3", "Direccion3"));
            clientes.add(new ClienteDTO(4L, "Nombre4", "Apellido4", "Direccion4"));
        }
        
    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// muestra información 
    	logger.info("Inicializada la lista de clientes");
    	logger.info("Clientes:\t" + clientes );
    }    
    
	/**
	 * Obtiene el listado de personas. 
	 * @return lista de ciudades
	 * @throws CityLogicException cuando no existe la lista en memoria  
	 */    
    public List<ClienteDTO> darClientes() throws LogicaRestauranteException 
    {
    	if (clientes == null) 
        {
    		logger.severe("Error interno: lista de clientes no existe.");
    		throw new LogicaRestauranteException("Error interno: lista de clientes no existe.");    		
    	}
    	logger.info("retornando todas las ciudades");
    	return clientes;
    }

    /**
     * Agrega un cliente al sistema.
     * @param nuevoCliente Cliente a agregar.
     * @throws CityLogicException cuando ya existe un Cliente con el id suministrado
     * @return Cliente agregado.
     */
    public ClienteDTO createCity(ClienteDTO nuevoCliente) throws LogicaRestauranteException 
    {
    	logger.info("Recibiendo solicitud de agregar cliente: " + nuevoCliente);
    	
    	// Si el nuevo cliente ya tiene identificador
    	if ( nuevoCliente.darId() != null ) 
        {
	    	// busca la ciudad con el id suministrado
	        for (ClienteDTO cliente : clientes) 
                {
	        	// si existe una ciudad con ese id
	            if (Objects.equals(cliente.darId(), nuevoCliente.darId()))
                    {
	            	logger.severe("Ya existe una ciudad con ese id");
	                throw new LogicaRestauranteException("Ya existe una ciudad con ese id");
	            }
	        }
	        
	// El nuevo cliente no tiene identificador 
    	} 
        else 
        {
    		// genera un id para la ciudad
    		logger.info("Generando id paa la nueva ciudad");
    		Long newId = 1L;
	        for (ClienteDTO cliente : clientes) 
                {
	            if (newId <= cliente.darId())
                    {
	                newId =  cliente.darId() + 1;
	            }
	        }
	        nuevoCliente.asignarId(newId);
    	}
    	
        // agrega la ciudad
    	logger.info("Agregando Cliente: " + nuevoCliente);
        clientes.add(nuevoCliente);
        return nuevoCliente;
    }

   
}
