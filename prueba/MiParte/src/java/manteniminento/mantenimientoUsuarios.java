/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manteniminento;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import persistencia.Login;

/**
 *
 * @author roberto.hernandezUSA
 */
public class mantenimientoUsuarios {
    
    public boolean guardar(Login objeto){
        EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(objeto);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }finally{
            em.close();
        }
    }
    
    public boolean borrarId(int id){
        EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Login objeto=null;
        try {
            objeto=em.find(Login.class, id);
            em.remove(objeto);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }finally{
            em.close();
        }
    }
    
    public boolean actualizar(Login objeto){
        EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Login objeto2=null;
        try {
            objeto2=em.find(Login.class, objeto.getIdLogin());
            objeto2=objeto;
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }finally{
            em.close();
        }
    }
    
    public Login consultar(int id){
        EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Login objeto=null;
        try {
            objeto=em.find(Login.class, id);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return objeto;
    }
    
    public List consultarTodo(){
        EntityManager em=JpaUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        List<Login> lista=null;
        try {
            Query q=em.createQuery("SELECT l FROM Login l");
            lista=q.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return lista;
    }
    
    
    
}
