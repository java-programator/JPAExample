package pl.altkom;

import pl.altkom.model.Customer;

import java.util.List;

public interface CustomerDAO {
    void openConnection();
    List<Customer> readAllCustomers();
    void addCustomer(Customer c);
    void deleteData();
    void closeConnection();
}
