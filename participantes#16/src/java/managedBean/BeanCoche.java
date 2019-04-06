/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entity.Coche;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import mantenimiento.MantenimientoCoche;

/**
 *
 * @author roberto.hernandezUSA
 */
@ManagedBean
@RequestScoped
public class BeanCoche {

    private Coche coche;
    
    private String tipoCoche;
    private MantenimientoCoche man=new MantenimientoCoche();
    
    @PostConstruct
    public void init(){
        this.coche=new Coche();
    }
    public BeanCoche() {
    }
    
    public void guardar(){
        String modelo=tipoCoche+coche.getMatricula();
       coche.setMatricula(modelo);
        if (man.guardar(coche)) {
            respuesta("guardo coche");
        } else {
            respuesta("no guardo coche");
        }
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public String getTipoCoche() {
        return tipoCoche;
    }

    public void setTipoCoche(String tipoCoche) {
        this.tipoCoche = tipoCoche;
    }
    
    private void respuesta(String respuesta){
        FacesMessage msg=new FacesMessage(respuesta);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
