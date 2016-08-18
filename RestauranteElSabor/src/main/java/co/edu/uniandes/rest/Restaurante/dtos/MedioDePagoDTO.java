/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.Restaurante.dtos;

import java.util.Date;

/**
 *
 * @author igomez10
 */



public class MedioDePagoDTO
{

    //ATRIBUTOS ATRIBUTOS ATRIBUTOS ATRIBUTOS ----------

    private Integer id;

    private Boolean efectivo;

    private String tarjeta;

    private Integer numerosTarjeta;

    private Date fechaVencimiento;

    private Integer codigoSeguridad;

    private String franquicia;

    public MedioDePagoDTO()
    {   }

    //CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR CONSTRUCTOR-----------

    public MedioDePagoDTO(Integer pId, Boolean pEfectivo, String pTarjeta, Integer pNumerosTarjeta, Date pFechaVencimiento, Integer pCodigoSeguridad, String pFranquicia )
    {
        super();
        this.id = pId;
        this.efectivo = pEfectivo;
        this.tarjeta = pTarjeta;
        this.numerosTarjeta = pNumerosTarjeta;
        this.fechaVencimiento=pFechaVencimiento;
        this.codigoSeguridad=pCodigoSeguridad;
        this.franquicia=pFranquicia;
    }

    //ASIGNAR ASIGNAR ASIGNAR ASIGNAR---------------------

    public void setId(Integer pId)
    {
        id = pId;
    }
    public void setEfectivo(Boolean pEfectivo)
    {
      efectivo=pEfectivo;
    }
    public void setTarjeta(String pTarjeta)
    {
      tarjeta=pTarjeta;
    }
    public void setNumerosTarjeta(Integer pNumerosTarjeta)
    {
      numerosTarjeta=pNumerosTarjeta;
    }
    public void setFechaVencimiento(Date pFechaVencimiento)
    {
      fechaVencimiento=pFechaVencimiento;
    }
    public void setCodigoSeguridad(Integer pCodigoSeguridad)
    {
      codigoSeguridad=pCodigoSeguridad;
    }
    public void setFranquicia(String pFranquicia)
    {
      franquicia=pFranquicia;
    }


    //DAR DAR DAR DAR DAR----------------------------------

    public Integer getId() {
        return id;
    }
    public Boolean getEfectivo(){
      return efectivo;
    }
    public String getTarjeta(){
      return tarjeta;
    }
    public Integer getNumerosTarjeta(){
      return numerosTarjeta;
    }
    public Date getFechaVencimiento(){
      return fechaVencimiento;
    }
    public Integer getCodigoSeguridad(){
      return codigoSeguridad;
    }
    public String getFranquicia(){
      return franquicia;
    }

    //TOSTRING TOSTRING TOSTRING TOSTRING ---------------------------

    @Override
    public String toString()
    {
    	return "{ id : " + getId() +", efectivo : \""+ getEfectivo() +"\", tarjeta : \""+getTarjeta()+"\", "
                + ", numeros de Tarjeta : \""+getNumerosTarjeta()+"\""+", fecha de vencimiento : \""+ getFechaVencimiento()+", codigoSeguridad : \""+getCodigoSeguridad()+", franquicia : \""+getFranquicia()
                + " }" ;
    }
}
