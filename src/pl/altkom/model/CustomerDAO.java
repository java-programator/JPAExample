package pl.altkom.model;

import java.util.List;

public interface CustomerDAO {
        List<Customer> readAllCustomers();
        void addCustomer(Customer customer);
    }





