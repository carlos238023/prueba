/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimiento;

import entity.Reserva;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import jpa.JPAUtils;

/**
 *
 * @author roberto.hernandezUSA
 */
public class MantenimientoReserva extends AbstractFacade<Reserva>{

    private EntityManager em;
    public MantenimientoReserva() {
        super(Reserva.class);
        getEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em==null) {
            em=JPAUtils.getEntityManager();
        }
        return em;
                
    }
    
    public void procedimientoGuardar(Reserva reserva){
        EntityManager em=JPAUtils.getEntityManager();
        em.getTransaction().begin();
        
        StoredProcedureQuery procedureQuery=em.createStoredProcedureQuery("sp_insercion_reserva");
        procedureQuery.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter(2, Date.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter(3, Date.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter(4, double.class, ParameterMode.IN);
        procedureQuery.registerStoredProcedureParameter(5, Integer.class, ParameterMode.IN);
        procedureQuery.setParameter(0, reserva.getIdReserva());
        procedureQuery.setParameter(1,reserva.getCodCliente().getIdCliente());
        procedureQuery.setParameter(2,reserva.getFechaInicio());
        procedureQuery.setParameter(3,reserva.getFechaFinal());
        procedureQuery.setParameter(4,reserva.getPrecioAlquiler());
        procedureQuery.setParameter(5,reserva.getListrosGasolina());
        procedureQuery.execute();
        
        em.getTransaction().commit();
        
        em.close();
        
    }
    
    
}
