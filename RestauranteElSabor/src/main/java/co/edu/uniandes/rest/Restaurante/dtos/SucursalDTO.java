/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.Restaurante.dtos;

/**
 *
 * @author af.pinzon10
 */
public class SucursalDTO 
{
    private Long id;
    
    private String ciudad;
    
    private String direccion;
    
    private int mesas;
    
    private int calificacion;
    
    public SucursalDTO()
    {   }
    
    public SucursalDTO(Long pId, String pCiudad, String pDireccion, int pMesas, int pCalificacion)
    {
        super();
        this.id = pId;
        this.ciudad = pCiudad;
        this.direccion = pDireccion;
        this.mesas = pMesas;
        this.calificacion = pCalificacion;
    }

    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getCiudad()
    {
        return ciudad;
    }
    
    public void setCiudad(String ciudad)
    {
        this.ciudad = ciudad;
    }

    public String getDireccion() 
    {
        return direccion;
    }

    public void setDireccion(String direccion) 
    {
        this.direccion = direccion;
    }
    
    public int getMesas()
    {
        return mesas;
    }
    
    public void setMesas(int mesas)
    {
        this.mesas = mesas;
    }
    
    public int getCalificacion()
    {
        return calificacion;
    }
    
    public void setCalificacion(int calificacion)
    {
        this.calificacion = calificacion;
    }
        
    /**
     * Representacion JSON de un cliente
     * @return La representacion JSON de un DTO Sucursal.
     */
    @Override
    public String toString() 
    {
    	return "{ id : " + id + ", ciudad : \""+ ciudad +"\", direccion : \""+direccion+"\", mesas : \""+mesas+"\", calificacion : \""+calificacion+"\" }" ;  
    }
    
}
