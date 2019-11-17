package pl.altkom;

import pl.altkom.model.Role;
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

            Role role = new Role();
            role.setName("admin");
            em.persist(role);

            User user = new User("Pawel");
            user.setRole(role);
            em.persist(user);

            user = new User("Bogdan");
            user.setRole(role);
            em.persist(user);

            role = new Role();
            role.setName("user");
            em.persist(role);

            user = new User("Marian");
            user.setRole(role);
            em.persist(user);

            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
