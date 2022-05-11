package dev.chris5011.projects.springexampleproject.service;

import dev.chris5011.projects.springexampleproject.exception.CustomerNotFoundException;
import dev.chris5011.projects.springexampleproject.exception.CustomerNotOldEnoughException;
import dev.chris5011.projects.springexampleproject.exception.ProductNotFoundException;
import dev.chris5011.projects.springexampleproject.model.Customer;
import dev.chris5011.projects.springexampleproject.model.Product;
import dev.chris5011.projects.springexampleproject.repository.CustomerRepository;
import dev.chris5011.projects.springexampleproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();

        if (customerList.isEmpty()) {
            throw new CustomerNotFoundException("There were no Customers to Load from the Database!");
        }
        return customerList;
    }

    public Customer findCustomerById(int id) {
        Optional<Customer> optCust = customerRepository.findById(id);
        if (optCust.isEmpty()) {
            throw new CustomerNotFoundException("Could not find a Customer with the id " + id);
        }
        return optCust.get();
    }

    public Customer findCustomerByFirstName(String firstname) {
        Optional<Customer> optCust = customerRepository.findCustomerByFirstName(firstname);
        if (optCust.isEmpty()) {
            throw new CustomerNotFoundException("Could not find a Customer with the firstname: " + firstname);
        }
        return optCust.get();
    }

    public List<Customer> findCustomersByFavouriteProduct(int productId) {
        Optional<Product> optProduct = productRepository.findById(productId);
        if (optProduct.isEmpty()) {
            throw new ProductNotFoundException("Could not find a Product with the id: " + productId);
        }

        Product product = optProduct.get();

        List<Customer> customerList = customerRepository.findCustomersByFavouriteProduct(product);

        if (customerList.isEmpty()) {
            throw new CustomerNotFoundException("There were no Customers with the Favourite Product: " + product.getProductName());
        }
        return customerList;
    }

    public Customer addCustomer(Customer customer) {
        //Ein neuer Kunde darf keine ID zugewiesen haben, damit er eingefügt werden kann
        if (customer.getId() != 0) {
            throw new IllegalArgumentException("A new Customer must not have an id!");
        }

        //Ein neuer Kunde muss mindestens 18 Jahre sein damit er registriert werden darf:
        Period period = Period.between(customer.getBirthdate(), LocalDate.now());
        int customerAge = period.getYears();

        if (customerAge < 18) {
            throw new CustomerNotOldEnoughException("The Customer is not old enough!");
        }

        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("The supplied customer is null!");
        }

        if (customer.getId() == 0) {
            throw new IllegalArgumentException("The supplied customer does not have an id! Did you want to insert them?");
        }

        //Ein neuer Kunde muss mindestens 18 Jahre sein:
        Period period = Period.between(customer.getBirthdate(), LocalDate.now());
        int customerAge = period.getYears();

        if (customerAge < 18) {
            throw new CustomerNotOldEnoughException("The Customer is not old enough!");
        }

        return customerRepository.save(customer);
    }

    public Customer deleteCustomerById(int id) {
        Optional<Customer> optCust = customerRepository.findById(id);

        if (optCust.isEmpty()) {
            throw new CustomerNotFoundException("Could not find a Customer with the id: " + id);
        }
        Customer customer = optCust.get();

        customerRepository.delete(customer);
        return customer;
    }


    public int getCustomerCount() {
        int customerCount = (int) customerRepository.count();
        return customerCount;
    }


}
