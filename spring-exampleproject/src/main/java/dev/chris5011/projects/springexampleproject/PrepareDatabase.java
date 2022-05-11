package dev.chris5011.projects.springexampleproject;

import dev.chris5011.projects.springexampleproject.model.Customer;
import dev.chris5011.projects.springexampleproject.model.Product;
import dev.chris5011.projects.springexampleproject.repository.CustomerRepository;
import dev.chris5011.projects.springexampleproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PrepareDatabase implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Autowired
    public PrepareDatabase(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {

        Product p1 = new Product(1, "Truffle Shells - White Chocolate", 8.22);
        Product p2 = new Product(2, "Cookie Choc", 12.84);
        Product p3 = new Product(3, "Pastry - Banana Tea Loaf", 17.24);
        Product p4 = new Product(4, "Coconut - Creamed, Pure", 13.65);
        Product p5 = new Product(5, "Beer - Upper Canada Lager", 2.64);

        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);
        productRepository.save(p4);
        productRepository.save(p5);


        customerRepository.save(new Customer(1, "Berke", "Sharrard", LocalDate.of(2000, 3, 23), "Canada", p5));
        customerRepository.save(new Customer(2, "Gaston", "Ottiwill", LocalDate.of(2001, 3, 15), "Italy", p1));
        customerRepository.save(new Customer(3, "Mabel", "Dunrige", LocalDate.of(2000, 7, 18), "Austria", p3));
        customerRepository.save(new Customer(4, "Karalynn", "Marlow", LocalDate.of(2000, 9, 2), "Canada", p3));
        customerRepository.save(new Customer(5, "Florence", "Coysh", LocalDate.of(2000, 4, 4), "Germany", p2));
        customerRepository.save(new Customer(6, "Kimberlee", "Lambe", LocalDate.of(2000, 12, 29), "Germany", p5));
        customerRepository.save(new Customer(7, "Laina", "Holyland", LocalDate.of(2000, 5, 10), "USA", p4));
        customerRepository.save(new Customer(8, "Hallie", "Macklin", LocalDate.of(2000, 2, 3), "Japan", p3));
        customerRepository.save(new Customer(9, "Ailina", "Leglise", LocalDate.of(2001, 1, 22), "Italy", p2));
        customerRepository.save(new Customer(10, "Bryon", "Duchasteau", LocalDate.of(2001, 1, 2), "Germany", p4));
        customerRepository.save(new Customer(11, "Alie", "Pitkin", LocalDate.of(2000, 4, 8), "Germany", p3));
        customerRepository.save(new Customer(12, "Loralie", "Norster", LocalDate.of(2000, 1, 18), "Japan", p5));
        customerRepository.save(new Customer(13, "Port", "Knevet", LocalDate.of(2001, 11, 1), "USA", p4));
        customerRepository.save(new Customer(14, "Leonelle", "McGrory", LocalDate.of(2001, 1, 11), "Japan", p5));
        customerRepository.save(new Customer(15, "Andriana", "Berggren", LocalDate.of(2000, 2, 29), "Italy", p3));

    }
}
