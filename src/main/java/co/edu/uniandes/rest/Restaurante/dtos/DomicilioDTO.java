/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.Restaurante.dtos;

/**
 *
 * @author cc.novoa11
 */

public class DomicilioDTO 
{
    /**
     * Atributos
     */
    private Long id;
    
    private String direccion;
    
    private String plato;
    
    private int precio;
    
    /**
     * Constructor por defecto
     */
    public DomicilioDTO()
    {   }
    /**
     * Constructor por con parámetros dados
     * @param pId
     * @param pDir
     * @param pPlato
     * @param pPrecio
     */
    public DomicilioDTO(Long pId, String pDir, String pPlato, int pPrecio)
    {
        super();
        this.id = pId;
        this.direccion = pDir;
        this.plato = pPlato;
        this.precio = pPrecio;
    }
    
    /**
     * Métodos
     */
    
    /**
     * Obtener el id del domicilio.
     * @return id
     */

    public Long getId() 
    {
        return id;
    }
    
    /**
     * Asignar un nuevo id.
     * @param id 
     */

    public void setId(Long id) 
    {
        this.id = id;
    }
    /**
     * Obtener la dirección del domicilio.
     * @return direccion
     */

    public String getDir() 
    {
        return direccion;
    }
    
    /**
     * Asignar una nueva direccion.
     * @param direccion 
     */

    public void setDir(String direccion) 
    {
        this.direccion = direccion;
    }
    
    /**
     * Obtener el plato del domicilio.
     * @return plato
     */

    public String getPlato() 
    {
        return plato;
    }
    
    /**
     * Asignar un nuevo plato.
     * @param nPlato 
     */

    public void setPlato(String nPlato) 
    {
        this.plato = nPlato;
    }
    /**
     * Obtener el precio del domicilio.
     * @return precio
     */
    
    public int getPrecio() 
    {
        return precio;
    }
    
    /**
     * Asignar un nuevo precio.
     * @param nPrecio 
     */

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
