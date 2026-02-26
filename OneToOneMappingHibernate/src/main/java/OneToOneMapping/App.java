package OneToOneMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        // Create EntityManagerFactory using persistence-unit name
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("OneToOneMappingInHibernate");

        EntityManager em = emf.createEntityManager();

        // Begin Transaction
        em.getTransaction().begin();

        // Create Account
        Account account = new Account("ACC12345", "Savings");

        // Create Customer
        Customer customer = new Customer();
        customer.setName("Nitin");
        customer.setAccount(account);

        // Set bi-directional link
        account.setCustomer(customer);

        // Persist (Account auto-saved due to CascadeType.ALL)
        em.persist(customer);

        // Commit Transaction
        em.getTransaction().commit();

        // Close resources
        em.close();
        emf.close();

        System.out.println("Data inserted successfully ✅");
    }
}
