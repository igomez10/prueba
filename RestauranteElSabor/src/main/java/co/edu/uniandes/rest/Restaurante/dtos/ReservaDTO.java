/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

import java.util.Date;
/**
 *
 * @author aj.paredes10
 */
public class ReservaDTO {
    
    //ATRIBUTOS
    
    private Long id;
    private Date fecha;
    private int numPersonas;
    private int piso;
   
    /**
     * Constructor por defecto
     */ 
    public ReservaDTO(){
        
    }
    /**
     * Constructor con parámetros.
     * @param id
     * @param fecha
     * @param numPersonas
     * @param piso
     */
    public ReservaDTO(Long id, Date fecha, int numPersonas, int piso){
        this.id = id;
        this.fecha = fecha;
        this.numPersonas = numPersonas;
        this.piso = piso;
    }
    
    //METODOS
    
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id =id;
    }
    
    public Date getFecha(){
        return fecha;
    }
    public void setFecha(Date fecha){
        this.fecha =fecha;
    }
    
    public int getNumPersonas(){
        return numPersonas;
    }
    public void setNumPersonas(int numPersonas){
        this.numPersonas =numPersonas;
    }
    
    public int getPiso(){
        return piso;
    }
    public void setPiso(int piso){
        this.piso =piso;
    }
}
