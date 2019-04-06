/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimiento;

import entity.Cliente;
import javax.persistence.EntityManager;
import jpa.JPAUtils;

/**
 *
 * @author roberto.hernandezUSA
 */
public class MantenimientoCliente extends AbstractFacade<Cliente>{

   private EntityManager em;
    public MantenimientoCliente() {
        super(Cliente.class);
        getEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em==null) {
            em=JPAUtils.getEntityManager();
        }
        return em;
    }
    
    
}
