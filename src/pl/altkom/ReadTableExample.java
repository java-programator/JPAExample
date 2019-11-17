package pl.altkom;

import pl.altkom.model.User;

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
            List<User> users = em.createQuery("" +
                    "select u from User u WHERE u.role.name = 'admin'", User.class)
                    .getResultList();
            em.getTransaction().commit();
            users.forEach(System.out::println);
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
