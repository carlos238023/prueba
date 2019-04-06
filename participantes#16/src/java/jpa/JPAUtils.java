/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author roberto.hernandezUSA
 */
public class JPAUtils {
    
    private static String NOMBRE_UNIDAD_PERSISTENCIA="participantes_16PU";
    
    public static EntityManager getEntityManager(){
        EntityManager em=null;
        EntityManagerFactory emf=null;
        try {
            emf=Persistence.createEntityManagerFactory(NOMBRE_UNIDAD_PERSISTENCIA);
            em=emf.createEntityManager();
        } catch (Exception e) {
            System.out.println("error en la conexion entity");
            e.printStackTrace();
        }
        return em;
    }
    
}
