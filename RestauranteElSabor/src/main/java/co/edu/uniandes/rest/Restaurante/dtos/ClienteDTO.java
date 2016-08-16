/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

/**
 *
 * @author jdguz
 */
public class ClienteDTO 
{
    private Long id;
    
    private String nombre;
    
    private String apellidos;
    
    private String direccion;
    
    public ClienteDTO()
    {   }
    
    public ClienteDTO(Long pId, String pNombre, String pApellidos, String pDireccion)
    {
        super();
        this.id = pId;
        this.nombre = pNombre;
        this.apellidos = pApellidos;
        this.direccion = pDireccion;
    }
    
    public void asignarId(Long pId)
    {
        id = pId;
    }
    
    public void asignarNombre(String pNombre)
    {
        nombre = pNombre;
    }
    
    public void asignarApellidos(String pApellidos)
    {
        apellidos = pApellidos;
    }
    
    public void asignarDireccion(String pDireccion)
    {
        direccion = pDireccion;
    }
    
    public Long darId()
    {
        return id;
    }
    
    public String darNombre()
    {
        return nombre;
    }
    
    public String darApellidos()
    {
        return apellidos;
    }
    
    public String darDireccion()
    {
        return direccion;
    }
    
    @Override
    public String toString() 
    {
    	return "{ id : " + darId() +", nombre : \""+ darNombre() +"\", apellidos : \""+darApellidos()+"\", "
                + "direccion : \""+darDireccion()+"\""
                + " }" ;  
    }
}
