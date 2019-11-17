package pl.altkom;

import pl.altkom.model.Customer;
import pl.altkom.model.CustomerDaoImpl;
import pl.altkom.model.Sex;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateTableMain {

    public static void main(String[] args) {
        CustomerDAO dao = new CustomerDaoImpl();

        dao.openConnection();

        dao.addCustomer(new Customer(1, "A", "B", "polska", 25, Sex.MALE));


    }
}
