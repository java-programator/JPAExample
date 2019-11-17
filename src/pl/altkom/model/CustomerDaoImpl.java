package pl.altkom.model;

import pl.altkom.CustomerDAO;

import javax.persistence.*;
import java.util.List;

public class CustomerDaoImpl implements CustomerDAO {
        private EntityManagerFactory emf = null;
    @Override
    public void openConnection() {
        emf = Persistence.createEntityManagerFactory("USER_PU");
    }
    @Override
    public void closeConnection() {
        emf.close();
    }

    @Override
    public void createCustomerTable() {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("USER_PU");

        } finally {
            if (emf != null) emf.close();
        }
    }

        @Override
        public void addCustomer (Customer c){
            EntityManager em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();
            em.persist(c);
            transaction.commit();

            em.close();
    }

        @Override
        public List<Customer> readAllCustomers () {
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery("SELECT c FROM Customer c");
            return query.getResultList();
        }

        @Override
        public void deleteData () {
        List<Customer> customers = readAllCustomers();
        EntityManager em = emf.createEntityManager();

        customers.forEach(customer -> em.remove(customer));
        em.getTransaction().commit();

        em.close();
        }

}