package co.edu.uniandes.rest.Restaurante.mocks;

import co.edu.uniandes.rest.Restaurante.dtos.SucursalDTO;
import co.edu.uniandes.rest.cities.exceptions.LogicaRestauranteException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * CityLogicMock
 * Mock del recurso Sucursales (Mock del servicio REST)
 */

public class MockSucursales 
{	
    // Objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(MockSucursales.class.getName());
	
    // Arreglo de sucursales.
    private static ArrayList<SucursalDTO> sucursales;

    
    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public MockSucursales() 
    {
    	if (sucursales == null) 
        {
            sucursales = new ArrayList<SucursalDTO>();
            sucursales.add(new SucursalDTO(1L, "Ciudad1", "Direccion1", 1));
            sucursales.add(new SucursalDTO(2L, "Ciudad2", "Direccion2", 2));
            sucursales.add(new SucursalDTO(3L, "Ciudad3", "Direccion3", 3));
            sucursales.add(new SucursalDTO(4L, "Ciudad4", "Direccion4", 4));
        }
        
    	// Indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// Muestra información 
    	logger.info("Inicializada la lista de sucursales");
    	logger.info("Sucursales:\n" + sucursales );
    }    
    
    /**
    * Obtiene el listado de sucursales. 
    * @return Lista de sucursales
    * @throws LogicaRestauranteException cuando no existe la lista en memoria  
    */    
    public List<SucursalDTO> darSucursales() throws LogicaRestauranteException 
    {
        logger.info("Recibiendo solicitud de dar todas las sucursales.");
        
    	if (sucursales == null) 
        {
    		logger.severe("Error interno: lista de sucursales no existe.");
    		throw new LogicaRestauranteException("Error interno: lista de sucursales no existe.");    		
    	}
        
    	logger.info("Retornando todas las sucursales.");
    	return sucursales;
    }
    
    /**
    * Obtiene la sucursal con el id que entra por parametro. 
    * @return SucursalDTO Sucursal buscado.
    * @throws LogicaRestauranteException Cuando no existe una sucursal con el id buscado.  
    */    
    public SucursalDTO darSucursal(Long pId) throws LogicaRestauranteException 
    {
        logger.info("Recibiendo solicitud de dar la sucursal con id "+pId+".");
        
    	if (sucursales == null) 
        {
    		logger.severe("Error interno: lista de sucursales no existe.");
    		throw new LogicaRestauranteException("Error interno: lista de sucursales no existe.");    		
    	}
        
        for(SucursalDTO sucursal:sucursales)
        {
            if(sucursal.getId().equals(pId))
            {
                logger.info("Retornando la sucursal con id "+pId);
                return sucursal;
            }
        }
    	logger.severe("Error de uso: Se pidio una sucursal que no existe.");
    	throw new LogicaRestauranteException("Error de uso: Se pidio una sucursal que no existe.");
    }

    /**
     * Agrega una sucursal al sistema.
     * @param nuevaSucursal Sucursal a agregar.
     * @return Sucursal agregada.
     */
    public SucursalDTO crearSucursal(SucursalDTO nuevaSucursal) throws LogicaRestauranteException
    {
    	logger.info("Recibiendo solicitud de agregar sucursal.");
        Long idSucursalAAgregar = nuevaSucursal.getId();
        
    	// Se busca que no exista un sucursal con ese id.
	for (SucursalDTO sucursal : sucursales) 
        {
            if(sucursal.getId().equals(idSucursalAAgregar))
            {
                logger.severe("Error de uso: Se intento crear una sucursal con un id "+idSucursalAAgregar+" que ya existia.");
                throw new LogicaRestauranteException("Error de uso: Se intento crear una sucursal con un id "+idSucursalAAgregar+" que ya existia.");
            }
	}
	
        // Se Agrega el sucursal.
    	logger.info("Agregando Sucursal: " + nuevaSucursal);
        sucursales.add(nuevaSucursal);
        return nuevaSucursal;
    }

  public SucursalDTO actualizarSucursal(SucursalDTO sucursalActualizada) throws LogicaRestauranteException
   {   
       logger.info("Recibiendo solicitud de actualizar sucursal."); 
       Long id = sucursalActualizada.getId();
       
       // Se busca el sucursal a actualizar
        for (SucursalDTO sucursal : sucursales) 
        {
            if(sucursal.getId().equals(id))
            {
                String ciudad = sucursalActualizada.getCiudad();
                String direccion = sucursalActualizada.getDireccion();
                int mesas = sucursalActualizada.getMesas();
                
                if(ciudad != null && !ciudad.equalsIgnoreCase(""))
                {
                    sucursal.setCiudad(ciudad);
                }
                if(direccion != null && !direccion.equalsIgnoreCase(""))
                {
                    sucursal.setDireccion(direccion);
                }
                if(mesas < 0)
                {
                    sucursal.setMesas(mesas);
                }
                return sucursal;
            }
	}
       
      // Si se llega hasta aca es porque no se encontro sucursal con el id buscado.
        logger.severe("Error de uso: Se pidio actualizar una sucursal que no existe.");
        throw new LogicaRestauranteException("Error de uso: Se pidio actualizar una sucursal que no existe.");
   }
   
      public void eliminarSucursal(Long pId) throws LogicaRestauranteException
   {
       boolean eliminado = false;
       
        // Se busca la sucursal a eliminar
        for (int i = 0; i< sucursales.size() && !eliminado; i++) 
        {
            SucursalDTO sucursal = sucursales.get(i);
            if(sucursal.getId().equals(pId))
            {
                sucursales.remove(i);
                eliminado = true;
            }
        }
       
        if(!eliminado)
        {
        // Si se llega hasta aca es porque no se encontro sucursal con el id buscado.
        logger.severe("Error de uso: Se pidio eliminar una sucursal con id "+pId+" que no existe.");
        throw new LogicaRestauranteException("Error de uso: Se pidio eliminar una sucursal con id "+pId+" que no existe.");
        }
   }
}
