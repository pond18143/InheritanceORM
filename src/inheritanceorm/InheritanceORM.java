/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritanceorm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

/**
 *
 * @author poramet
 */
public class InheritanceORM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean loop = true;

        while (loop) {
            Scanner reader = new Scanner(System.in);
            System.out.println("1:FulltimeEmployee ");
            System.out.println("2:ParttimeEmployee ");
            System.out.println("3:For EXIST ");
            System.out.print("What\'s Table Number do you want to use: ");

            char floor = reader.next().charAt(0);
            switch (floor) {
                case '1'://Fulltime
                    System.out.println("FulltimeEmployee ");
                    System.out.println("1:Insert ");
                    System.out.println("2:Update ");
                    System.out.println("3:Delete ");
                    System.out.print("What\'s Command Number do you want to use: ");
                    char Full = reader.next().charAt(0);

                    //insert
                    if (Full == '1') {
                        System.out.println("1:Insert ");
                        System.out.print("Name: ");
                        String inpName = reader.next();
                        System.out.print("Salary: ");
                        int inpSalary = reader.nextInt();

                        FulltimeEmployee emp1 = new FulltimeEmployee();
                        emp1.setName(inpName);
                        emp1.setSalary(inpSalary);
                        emp1.insertFulltime(emp1);//insert
                        System.out.println("Insert Success! \n");
                        break;
                    } //update byId
                    else if (Full == '2') {
                        System.out.println("2:Update ");
                        System.out.print("Id: ");
                        long inpId = reader.nextInt();
                        System.out.print("Name: ");
                        String inpName = reader.next();
                        System.out.print("Salary: ");
                        int inpSalary = reader.nextInt();

                        FulltimeEmployee emp1 = new FulltimeEmployee();
                        emp1.setId(inpId);
                        emp1.setName(inpName);
                        emp1.setSalary(inpSalary);
                        emp1.updateFulltime(emp1);//update
                        System.out.println("Update Success! \n");
                        break;
                    } //delete byId
                    else if (Full == '3') {
                        System.out.println("3:Delete ");
                        System.out.print("Id: ");
                        long inpId = reader.nextInt();

                        FulltimeEmployee emp1 = new FulltimeEmployee();
                        emp1.setId(inpId);

                        emp1.removeFulltime(emp1);//delete
                        System.out.println("Delete Success! \n");
                        break;
                    } else {
                        continue;
                    }
                case '2'://Parttime
                    System.out.println("ParttimeEmployee ");
                    System.out.println("1:Insert ");
                    System.out.println("2:Update ");
                    System.out.println("3:Delete ");
                    System.out.print("What\'s Command Number do you want to use: ");
                    char Part = reader.next().charAt(0);

                    //insert
                    if (Part == '1') {
                        System.out.println("1:Insert ");
                        System.out.print("Name: ");
                        String inpName = reader.next();
                        System.out.print("HoursWork: ");
                        int inpHourWork = reader.nextInt();

                        ParttimeEmployee emp2 = new ParttimeEmployee();
                        emp2.setName(inpName);
                        emp2.setHoursWork(inpHourWork);
                        emp2.insertParttime(emp2);//insert
                        System.out.println("Insert Success! \n");
                        break;
                    } //update byId
                    else if (Part == '2') {
                        System.out.println("2:Update ");
                        System.out.print("Id: ");
                        long inpId = reader.nextInt();
                        System.out.print("Name: ");
                        String inpName = reader.next();
                        System.out.print("HoursWork: ");
                        int inpHourWork = reader.nextInt();

                        ParttimeEmployee emp2 = new ParttimeEmployee();
                        emp2.setId(inpId);
                        emp2.setName(inpName);
                        emp2.setHoursWork(inpHourWork);
                        emp2.updateParttime(emp2);//update
                        System.out.println("Update Success! \n");
                        break;
                    } //delete byId
                    else if (Part == '3') {
                        System.out.println("3:Delete ");
                        System.out.print("Id: ");
                        long inpId = reader.nextInt();

                        ParttimeEmployee emp2 = new ParttimeEmployee();
                        emp2.setId(inpId);
                        emp2.removeParttime(emp2);//delete
                        System.out.println("Delete Success! \n");
                        break;
                    }
                case '3': //End loop
                    System.out.println("END. ");
                    loop = false;
                    break;
                default: //continue
                    System.out.println("Plese Select. ");
                    continue;
            }
        }
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
