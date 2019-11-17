package pl.altkom;

import pl.altkom.model.Role;
import pl.altkom.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ReadTableExample2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("USER_PU");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Role role = em.createQuery(
                    "SELECT r from Role r where r.name = 'admin'",
                    Role.class)
                    .getSingleResult();
            List<User> users = role.getUsers();
            em.getTransaction().commit();
            users.forEach(System.out::println);
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
