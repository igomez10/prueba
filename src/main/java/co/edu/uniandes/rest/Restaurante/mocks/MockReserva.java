/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.Restaurante.mocks;

import DTOs.ReservaDTO;
import co.edu.uniandes.rest.cities.exceptions.LogicaRestauranteException;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aj.paredes10
 */
public class MockReserva {
    
    private final static Logger logger = Logger.getLogger(MockReserva.class.getName());
    
    private static ArrayList<ReservaDTO> reservas;
    
    public MockReserva() {
        
        if (reservas == null) {
            reservas = new ArrayList<>();
            reservas.add(new ReservaDTO(1L, new Date(), 1, 1));
            reservas.add(new ReservaDTO(2L, new Date(), 2, 1));
            reservas.add(new ReservaDTO(3L, new Date(), 3, 2));
            reservas.add(new ReservaDTO(4L, new Date(), 5, 2));
            reservas.add(new ReservaDTO(5L, new Date(), 4, 1));
        }
        
        // indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// muestra información 
    	logger.info("Inicializa la lista de reservas");
    	logger.info("reservas" + reservas );
    }
    /**
     *
     * @return
     * @throws LogicaRestauranteException
     */
    public List<ReservaDTO> getReservas() throws LogicaRestauranteException {
    	if (reservas == null) {
    		logger.severe("Error interno: lista de reservas no existe.");
    		throw new LogicaRestauranteException("Error interno: lista de reservas no existe.");    		
    	}
    	
    	logger.info("retornando todas las reservas");
    	return reservas;
    }
    
    public ReservaDTO getReserva(Long id) throws LogicaRestauranteException{
     
          for (ReservaDTO res : reservas) {

	            if (Objects.equals(res.getId(), id)){
                         return res;
                    }
        }
        logger.severe("Error interno: la reserva no existe.");
    		throw new LogicaRestauranteException("Error interno: la reserva no existe.");
    }
    
    public ReservaDTO createReserva(ReservaDTO nuevaReserva) throws LogicaRestauranteException {
    	logger.info("recibiendo solicitud de agregar reserva " + nuevaReserva);
    	
       	if ( nuevaReserva.getId() != null ) {
	    	for (ReservaDTO res : reservas) {
	            if (Objects.equals(res.getId(), nuevaReserva.getId())){
	            	logger.severe("Ya existe una reserva con ese id");
	                throw new LogicaRestauranteException("Ya existe una reserva con ese id");
	            }
	        }
	        
    	} else {
    		logger.info("Generando id para la nueva reserva");
    		long newId = 1;
	        for (ReservaDTO res : reservas) {
	            if (newId <= res.getId()){
	                newId =  res.getId() + 1;
	            }
	        }
	        nuevaReserva.setId(newId);
    	}
    	
    	logger.info("agregando reserva " + nuevaReserva);
        reservas.add(nuevaReserva);
        return nuevaReserva;
    }
    
    public ReservaDTO updateReserva(ReservaDTO reserva) throws LogicaRestauranteException{
       for (ReservaDTO res : reservas) {

	    if (Objects.equals(res.getId(), reserva.getId())){
                res.setFecha(reserva.getFecha());
                res.setNumPersonas(reserva.getNumPersonas());
                res.setPiso(reserva.getPiso());
                return res;
            }
        }
       logger.severe("Error interno: la reserva no existe.");
    		throw new LogicaRestauranteException("Error interno: la reserva no existe.");
   }
    
    public void deleteReserva(Long id) throws LogicaRestauranteException{
       boolean borro = false;
       int i=0;
       for (ReservaDTO res : reservas) {

	    if (Objects.equals(res.getId(), id)){
                if (res != null){
                    reservas.remove(i);
                    borro= true;
                    break;
               }
            }
            i++;
        }
       if(!borro){
       logger.severe("Error interno: la reserva no existe.");
    		throw new LogicaRestauranteException("Error interno: la reserva no existe.");
       }
   }
   
}
