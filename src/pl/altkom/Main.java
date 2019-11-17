package pl.altkom;

import pl.altkom.model.Customer;
import pl.altkom.model.Sex;

public class Main {
    public static void main(String[] args) {
        CustomerDAO dao = new CustomerDAOImpl();
        dao.openConnection();
        dao.addCustomer(new Customer("A", "B", "C", 1, Sex.MALE));
        dao.readAllCustomers().forEach(System.out::println);
        dao.deleteData();
        dao.closeConnection();
    }
}
