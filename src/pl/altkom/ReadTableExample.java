package pl.altkom;

import pl.altkom.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ReadTableExample {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("USER_PU");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            List<Customer> users = em.createQuery("select c from Customer c", Customer.class).getResultList();
            em.getTransaction().commit();
            System.out.println(users);
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
