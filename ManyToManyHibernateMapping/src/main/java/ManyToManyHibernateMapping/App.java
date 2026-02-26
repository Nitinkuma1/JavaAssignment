package ManyToManyHibernateMapping;

import jakarta.persistence.*;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("ManyToMany");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Create Projects
        Project p1 = new Project("AI System");
        Project p2 = new Project("E-Commerce Website");

        // Create Employees
        Employee e1 = new Employee("Nitin", Arrays.asList(p1, p2));
        Employee e2 = new Employee("Rohan", Arrays.asList(p1));

        // Persist
        em.persist(e1);
        em.persist(e2);

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Inserted Successfully");
    }
}