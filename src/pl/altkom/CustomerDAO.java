package pl.altkom;

import pl.altkom.model.Customer;

import java.util.List;

public interface CustomerDAO {
    void openConnection();
    void closeConnection();
    void createCustomerTable();
    void addCustomer(Customer c);
    List<Customer> readAllCustomers();
    void deleteData();

}
