/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entities.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author mikke
 */
public class prodTest {
     private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/startcode",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);

     public static void main(String[] args) {
         EntityManager em = EMF.createEntityManager(); 
         Person p1 = new Person ("Rasmus", "Klump", "20204040"); 
         Person p2 = new Person ("Jule", "Manden", "10102020"); 
         try {
             em.getTransaction().begin();
             em.persist(p1);
             em.persist(p2);
             em.getTransaction().commit();
         }
         finally {
             em.close();
         }
     
     
     }
    
    
    
}
