package dev.chris5011.projects.springexampleproject.controller;

import dev.chris5011.projects.springexampleproject.model.Customer;
import dev.chris5011.projects.springexampleproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/listAll")
    public List<Customer> listAllCustomer() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/id/{id}")
    public Customer findCustomerById(@PathVariable(name = "id") int customerId) {
        return customerService.findCustomerById(customerId);
    }

    @GetMapping("/firstname/{firstname}")
    public Customer findCustomerByFirstName(@PathVariable(name = "firstname") String firstname) {
        return customerService.findCustomerByFirstName(firstname);
    }

    @GetMapping("/product/{productId}")
    public List<Customer> findCustomerByFavouriteProductId(@PathVariable(name = "productId") int productId) {
        return customerService.findCustomersByFavouriteProduct(productId);
    }

    @PostMapping("/")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.addCustomer(customer);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id/{id}")
                .build(newCustomer.getId())).body(newCustomer);
    }

    @PutMapping("/")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping(value = "/id/{id}", produces = "application/json")
    public Customer deleteCustomerById(@PathVariable(name = "id") int id) {
        return customerService.deleteCustomerById(id);
    }

    @GetMapping("/count")
    public int getCustomerCount() {
        return customerService.getCustomerCount();
    }


}
