package pl.altkom;

import pl.altkom.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateTableMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("USER_PU");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            User user = new User("Pawel");
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
