/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.Restaurante.dtos;

/**
 *
 */
public class DomicilioDTO 
{
    private Long id;
    
    private String direccion;
    
    private String plato;
    
    private int precio;
    
    
    public DomicilioDTO()
    {   }
    
    public DomicilioDTO(Long pId, String pDir, String pPlato, int pPrecio)
    {
        super();
        this.id = pId;
        this.direccion = pDir;
        this.plato = pPlato;
        this.precio = pPrecio;
    }

    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getDir() 
    {
        return direccion;
    }

    public void setDir(String direccion) 
    {
        this.direccion = direccion;
    }

    public String getPlato() 
    {
        return plato;
    }

    public void setPlato(String nPlato) 
    {
        this.plato = nPlato;
    }
    
    public int getPrecio() 
    {
        return precio;
    }

    public void setPrecio(int nPrecio) 
    {
        this.precio = nPrecio;
    }
        
    /**
     * Representacion JSON de un domicilio
     * @return La representacion JSON de un DTO domicilio.
     */
    @Override
    public String toString() 
    {
    	return "{ id : " + id +", direccion : \""+ direccion +"\", plato : \""+plato+"\", "
                + "precio : \""+precio+"\" }" ;  
    }
    
}
