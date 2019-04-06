/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimiento;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import jpa.JPAUtils;

/**
 *
 * @author roberto.hernandezUSA
 */
public abstract class AbstractFacade <T>{
    
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected  abstract  EntityManager getEntityManager();
    
    public boolean guardar(T entity)
    {
        EntityManager em=getEntityManager();
        EntityTransaction et=null;
        try {
            et=em.getTransaction();
            et.begin();
            em.persist(entity);
            et.commit();
            return true;
        } catch (Exception e) {
            if (et!=null&& et.isActive()) {
                et.rollback();
            }
            return false;
            
        }finally{
            if (em!=null && et.isActive()) {
                em.close();
                
            }
        }
    }
    
    
    public List consultarTodo(){
        
        EntityManager em=JPAUtils.getEntityManager();
        CriteriaQuery<T> cq=em.getCriteriaBuilder().createQuery(entityClass);
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }
    
}
