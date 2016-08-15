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
    // Objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(MockClientes.class.getName());
	
    // Arreglo de clientes.
    private static ArrayList<ClienteDTO> clientes;

    
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
        
    	// Indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// Muestra información 
    	logger.info("Inicializada la lista de clientes");
    	logger.info("Clientes:\t" + clientes );
    }    
    
    /**
    * Obtiene el listado de personas. 
    * @return Lista de ciudades
    * @throws LogicaRestauranteException cuando no existe la lista en memoria  
    */    
    public List<ClienteDTO> darClientes() throws LogicaRestauranteException 
    {
    	if (clientes == null) 
        {
    		logger.severe("Error interno: lista de clientes no existe.");
    		throw new LogicaRestauranteException("Error interno: lista de clientes no existe.");    		
    	}
    	logger.info("Retornando todas las ciudades");
    	return clientes;
    }
    
        /**
    * Obtiene el cliente con el id que entra por parametro. 
    * @return ClienteDTO Cliente buscado.
    * @throws LogicaRestauranteException Cuando no existe un cliente con el id buscado.  
    */    
    public ClienteDTO darCliente(Long pId) throws LogicaRestauranteException 
    {
    	if (clientes == null) 
        {
    		logger.severe("Error interno: lista de clientes no existe.");
    		throw new LogicaRestauranteException("Error interno: lista de clientes no existe.");    		
    	}
        
        for(ClienteDTO cliente:clientes)
        {
            if(cliente.darId().equals(pId))
            {
                logger.info("Retornando el cliente con id "+pId);
                return cliente;
            }
        }
    	logger.severe("Error de uso: Se pidio un cliente que no existe.");
    	throw new LogicaRestauranteException("Error de uso: Se pidio un cliente que no existe.");
    }

    /**
     * Agrega un cliente al sistema.
     * @param nuevoCliente Cliente a agregar.
     * @return Cliente agregado.
     */
    public ClienteDTO crearCliente(String pNombre, String pApellidos, String pDireccion)
    {
    	logger.info("Recibiendo solicitud de agregar cliente");
    	
    	// Se genera un ID para el cliente.
    	logger.info("Generando id paa la nueva ciudad");
    	Long newId = 1L;
	for (ClienteDTO cliente : clientes) 
        {
            if(newId <= cliente.darId())
            {
                newId =  cliente.darId() + 1;
            }
	}
	        ClienteDTO nuevoCliente = new ClienteDTO(newId, pNombre, pApellidos, pDireccion);
    	
        // AAgrega el cliente.
    	logger.info("Agregando Cliente: " + nuevoCliente);
        clientes.add(nuevoCliente);
        return nuevoCliente;
    }

   public ClienteDTO actualizarCliente(Long pId, String pNombre, String pApellidos, String pDireccion) throws LogicaRestauranteException
   {
       //TODO
       return null;
   }
   
      public void eliminarCliente(Long pId) throws LogicaRestauranteException
   {
       //TODO
   }
}
