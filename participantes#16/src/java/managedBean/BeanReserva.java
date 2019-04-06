/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entity.Reserva;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import mantenimiento.MantenimientoReserva;

/**
 *
 * @author roberto.hernandezUSA
 */
@ManagedBean
@RequestScoped
public class BeanReserva {

   private Reserva reserva;
   private MantenimientoReserva man=new MantenimientoReserva();
   
   @PostConstruct
   public void init(){
       this.reserva=new Reserva();
   }
    public BeanReserva() {
    }

    public void guardar(){
        try {
            man.procedimientoGuardar(reserva);
            respuesta("exito al realizar una reserva");
        } catch (Exception e) {
            respuesta("fallo al realizar la reserva");
        }
    }
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
    private void respuesta(String respuesta){
        FacesMessage msg= new FacesMessage(respuesta);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
   
}
