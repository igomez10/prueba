package co.edu.uniandes.rest.Restaurante.mocks;

import co.edu.uniandes.rest.cities.dtos.ClienteDTO;
import co.edu.uniandes.rest.cities.exceptions.LogicaRestauranteException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Mock del recurso Cliente.
 * @author jdguz
 */
public class MockClientes 
{	
    // Objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(MockClientes.class.getName());
	
    // Arreglo de clientes.
    private static ArrayList<ClienteDTO> clientes;
    
    /**
     * Constructor.
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
    * @param pId Id del cliente que se busca.
    * @return ClienteDTO Cliente buscado.
    * @throws LogicaRestauranteException Cuando no existe un cliente con el id buscado.  
    */    
    public ClienteDTO darCliente(Long pId) throws LogicaRestauranteException 
    {
        logger.info("Recibiendo solicitud de dar el cliente con id "+pId+".");
        
    	if (clientes == null) 
        {
    		logger.severe("Error interno: lista de clientes no existe.");
    		throw new LogicaRestauranteException("Error interno: lista de clientes no existe.");    		
    	}
        
        for(ClienteDTO cliente:clientes)
        {
            if(cliente.getId().equals(pId))
            {
                logger.info("Retornando el cliente.");
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
     * @throws LogicaRestauranteException Cuando se intenta crear un cliente que no existe. 
     */
    public ClienteDTO crearCliente(ClienteDTO nuevoCliente) throws LogicaRestauranteException
    {
        Long idClienteAAgregar = nuevoCliente.getId();
    	logger.info("Recibiendo solicitud de agregar cliente con id "+idClienteAAgregar+".");
        
    	// Se busca que no exista un cliente con ese id.
	for (ClienteDTO cliente : clientes) 
        {
            if(cliente.getId().equals(idClienteAAgregar))
            {
                logger.severe("Error de uso: Se intento crear un cliente con un id "+idClienteAAgregar+" que ya existia.");
                throw new LogicaRestauranteException("Error de uso: Se intento crear un cliente con un id "+idClienteAAgregar+" que ya existia.");
            }
        }
        // Se Agrega el cliente.
    	logger.info("Agregado satisfactoriamente el cliente");
        clientes.add(nuevoCliente);
        return nuevoCliente;
    }

    /**
     * Recibe un cliente y lo actualiza en el sistema.
     * @param nuevoCliente Cliente a agregar.
     * @return Cliente agregado.
     * @throws LogicaRestauranteException Cuando no existe un cliente con el id a actualizar. 
     */
    public ClienteDTO actualizarCliente(ClienteDTO clienteActualizado) throws LogicaRestauranteException
    {   
       Long id = clienteActualizado.getId();
       logger.info("Recibiendo solicitud de actualizar el cliente con id "+id+"."); 
       
       
       // Se busca el cliente a actualizar
        for (ClienteDTO cliente : clientes) 
        {
            if(cliente.getId().equals(id))
            {
                String nombre = clienteActualizado.getNombre();
                String apellidos =clienteActualizado.getApellidos();
                String direccion = clienteActualizado.getDireccion();
                
                if(nombre != null && !nombre.equalsIgnoreCase(""))
                {
                    cliente.setNombre(nombre);
                }
                if(apellidos !=null && !apellidos.equalsIgnoreCase(""))
                {
                    cliente.setApellidos(apellidos);
                }
                if(direccion != null && !direccion.equalsIgnoreCase(""))
                {
                    cliente.setDireccion(direccion);
                }
                logger.info("Actualizado satisfactoriamente."); 
                return cliente;
            }
	}
       
      // Si se llega hasta aca es porque no se encontro cliente con el id buscado.
        logger.severe("Error de uso: Se pidio actualizar un cliente que no existe.");
        throw new LogicaRestauranteException("Error de uso: Se pidio actualizar un cliente que no existe.");
   }
   
     /**
     * Elimina el cliente con el id dado.
     * @param pId Identificacion del cliente que se quiere eliminar.
     * @throws LogicaRestauranteException Cuando no existe un cliente con el id que se quiere eliminar. 
     */
      public void eliminarCliente(Long pId) throws LogicaRestauranteException
   {
       logger.info("Recibiendo solicitud de eliminar el cliente con id: " + pId+".");
       boolean eliminado = false;
       
        // Se busca el cliente a eliminar
        for (int i = 0; i< clientes.size() && !eliminado; i++) 
        {
            ClienteDTO cliente = clientes.get(i);
            if(cliente.getId().equals(pId))
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
        logger.info("Eliminado satisfactoriamente.");
   }
}
