/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manteniminento;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author roberto.hernandezUSA
 */
public class JpaUtil {
    
    private static final EntityManagerFactory emf;
    
    static{
        try {
            emf=Persistence.createEntityManagerFactory("");
        } catch (Throwable ex) {
            System.err.println("error en el inicio de session"+ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
    
    
}
