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
    private int id;
    
    private String nombre;
    
    private String apellidos;
    
    private String direccion;
    
    public ClienteDTO(int pId, String pNombre, String pApellidos, String pDireccion)
    {
        id = pId;
        nombre = pNombre;
        apellidos = pApellidos;
        direccion = pDireccion;
    }
    
    public int darId()
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
}
