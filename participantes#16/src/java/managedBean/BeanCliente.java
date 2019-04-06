/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entity.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import mantenimiento.MantenimientoCliente;

/**
 *
 * @author roberto.hernandezUSA
 */
@ManagedBean
@RequestScoped
public class BeanCliente {

   private Cliente cliente;
   private List<Cliente> listaCliente;
   private MantenimientoCliente man=new  MantenimientoCliente();
           
   
   @PostConstruct
   public void init(){
       this.cliente=new Cliente(0);
       llenarLista();
   }
           
   public void guardar(){
       cliente.setCodCliente(cliente.getNombre().substring(0, 2));
       
       if (man.guardar(cliente)) {
           respuesta("Guardo de manera exitosa");
       } else {
           respuesta("no guardo");
       }
   }
   public void llenarLista(){
       this.listaCliente=new ArrayList<>();
       this.listaCliente=man.consultarTodo();
   }
   
    
   
    public BeanCliente() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }
    
    private void respuesta(String respuesta){
        FacesMessage msg=new FacesMessage(respuesta);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
