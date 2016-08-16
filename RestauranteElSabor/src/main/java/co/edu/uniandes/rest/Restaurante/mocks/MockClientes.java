package co.edu.uniandes.rest.cities.mocks;

import co.edu.uniandes.rest.cities.dtos.ClienteDTO;
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
            clientes.add(new ClienteDTO(1L, "Nombre1", "Apellidos1", "Direccion1"));
            clientes.add(new ClienteDTO(2L, "Nombre2", "Apellidos2", "Direccion2"));
            clientes.add(new ClienteDTO(3L, "Nombre3", "Apellidos3", "Direccion3"));
            clientes.add(new ClienteDTO(4L, "Nombre4", "Apellidos4", "Direccion4"));
        }
        
    	// Indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// Muestra información 
    	logger.info("Inicializada la lista de clientes");
    	logger.info("Clientes:\n" + clientes );
    }    
    
    /**
    * Obtiene el listado de personas. 
    * @return Lista de ciudades
    * @throws LogicaRestauranteException cuando no existe la lista en memoria  
    */    
    public List<ClienteDTO> darClientes() throws LogicaRestauranteException 
    {
        logger.info("Recibiendo solicitud de dar todos los clientes.");
        
    	if (clientes == null) 
        {
    		logger.severe("Error interno: lista de clientes no existe.");
    		throw new LogicaRestauranteException("Error interno: lista de clientes no existe.");    		
    	}
        
    	logger.info("Retornando todos los clientes.");
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
    public ClienteDTO crearCliente(ClienteDTO nuevoCliente) throws LogicaRestauranteException
    {
    	logger.info("Recibiendo solicitud de agregar cliente.");
        Long idClienteAAgregar = nuevoCliente.darId();
        
    	// Se busca que no exista un cliente con ese id.
	for (ClienteDTO cliente : clientes) 
        {
            if(cliente.darId().equals(idClienteAAgregar))
            {
                logger.severe("Error de uso: Se intento crear un cliente con un id "+idClienteAAgregar+" que ya existia.");
                throw new LogicaRestauranteException("Error de uso: Se intento crear un cliente con un id "+idClienteAAgregar+" que ya existia.");
            }
	}
	
        // Se Agrega el cliente.
    	logger.info("Agregando Cliente: " + nuevoCliente);
        clientes.add(nuevoCliente);
        return nuevoCliente;
    }

  public ClienteDTO actualizarCliente(ClienteDTO clienteActualizado) throws LogicaRestauranteException
   {   
       logger.info("Recibiendo solicitud de actualizar cliente."); 
       Long id = clienteActualizado.darId();
       
       // Se busca el cliente a actualizar
        for (ClienteDTO cliente : clientes) 
        {
            if(cliente.darId().equals(id))
            {
                String nombre = clienteActualizado.darNombre();
                String apellidos =clienteActualizado.darApellidos();
                String direccion = clienteActualizado.darDireccion();
                
                if(nombre != null && !nombre.equalsIgnoreCase(""))
                {
                    cliente.asignarNombre(nombre);
                }
                if(apellidos !=null && !apellidos.equalsIgnoreCase(""))
                {
                    cliente.asignarApellidos(apellidos);
                }
                if(direccion != null && !direccion.equalsIgnoreCase(""))
                {
                    cliente.asignarDireccion(direccion);
                }
                return cliente;
            }
	}
       
      // Si se llega hasta aca es porque no se encontro cliente con el id buscado.
        logger.severe("Error de uso: Se pidio actualizar un cliente que no existe.");
        throw new LogicaRestauranteException("Error de uso: Se pidio actualizar un cliente que no existe.");
   }
   
      public void eliminarCliente(Long pId) throws LogicaRestauranteException
   {
       boolean eliminado = false;
       
        // Se busca el cliente a eliminar
        for (int i = 0; i< clientes.size() && !eliminado; i++) 
        {
            ClienteDTO cliente = clientes.get(i);
            if(cliente.darId().equals(pId))
            {
                clientes.remove(i);
                eliminado = true;
            }
        }
       
        if(!eliminado)
        {
        // Si se llega hasta aca es porque no se encontro cliente con el id buscado.
        logger.severe("Error de uso: Se pidio eliminar un cliente con id "+pId+" que no existe.");
        throw new LogicaRestauranteException("Error de uso: Se pidio eliminar un cliente con id "+pId+" que no existe.");
        }
   }
}
