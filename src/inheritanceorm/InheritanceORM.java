/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritanceorm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author poramet
 */
public class InheritanceORM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FulltimeEmployee emp1 = new FulltimeEmployee();
        emp1.setName("pond1");
        emp1.setSalary(10000);
        emp1.insertFulltime(emp1);//insert
//        emp1.setName("pondUpdate1");
//        emp1.setSalary(20000); 
//        emp1.updateFulltime(emp1);//update
//        emp1.removeFulltime(emp1);//delete
        
        ParttimeEmployee emp2 = new ParttimeEmployee();
        emp2.setName("pond2");
        emp2.setHoursWork(10);
        emp2.insertParttime(emp2);//insert
//        emp2.setName("pondUpdate2");
//        emp2.setHoursWork(20);
//        emp2.updateParttime(emp2);//update
//        emp2.removeParttime(emp2);//delete


    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InheritanceORMPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
