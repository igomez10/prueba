/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.Restaurante.dtos;

/**
 *
 * @author zl.castaneda
 */
public class PlatoDTO 
{
    private Long id;
    
    private String nombre;
    
    private int precio;
    
    private String descripcion;
    
    
    
    public PlatoDTO()
    {   }
    
    public PlatoDTO(Long pId, String pNombre, int pPrecio, String pDescripcion)
    {
        super();
        this.id = pId;
        this.nombre = pNombre;
        this.precio = pPrecio;
        this.descripcion = pDescripcion;
    }

    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public int getPrecio() 
    {
        return precio;
    }

    public void setPrecio(int elPrecio) 
    {
        this.precio = elPrecio;
    }

    public String getDescripcion() 
    {
        return descripcion;
    }

    public void setDireccion(String desc) 
    {
        this.descripcion = desc;
    }
        
    /**
     * Representacion JSON de un cliente
     * @return La representacion JSON de un DTO cliente.
     */
    @Override
    public String toString() 
    {
    	return "{ id : " + id +", nombre : \""+ nombre +"\", precio : \""+precio+"\", "
                + "descripcion : \""+descripcion+"\" }" ;  
    }
    
}
