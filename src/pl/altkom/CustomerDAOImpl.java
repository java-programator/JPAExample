package pl.altkom;

import pl.altkom.model.Customer;

import javax.persistence.*;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    private EntityManagerFactory emf = null;
    @Override
    public void openConnection() {
        emf = Persistence.createEntityManagerFactory("USER_PU");
    }

    @Override
    public List<Customer> readAllCustomers() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT c FROM Customer c");
        return query.getResultList();
    }

    @Override
    public void addCustomer(Customer c) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(c);
        transaction.commit();

        em.close();
    }

    @Override
    public void deleteData() {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Customer c");
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void closeConnection() {
        emf.close();
    }
}
