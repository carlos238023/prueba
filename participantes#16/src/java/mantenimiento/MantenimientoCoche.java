/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimiento;

import entity.Coche;
import javax.persistence.EntityManager;
import jpa.JPAUtils;

/**
 *
 * @author roberto.hernandezUSA
 */
public class MantenimientoCoche extends AbstractFacade<Coche>{

    private EntityManager em;
    public MantenimientoCoche() {
        super(Coche.class);
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
