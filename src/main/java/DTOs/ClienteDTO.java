/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

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
    
    public ClienteDTO(Long pId, String pNombre, String pApellidos, String pDireccion)
    {
        id = pId;
        nombre = pNombre;
        apellidos = pApellidos;
        direccion = pDireccion;
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
    
    public String toString() 
    {
    	return "{ id : " + id +",\t"
                + "nombre\" : \" "+ nombre +" \",\t"
                + "apellidos\" : \""+apellidos+"\",\t"
                + "direccion\" : \""+direccion+"\"\t"
                + "}" ;  
    }
}
