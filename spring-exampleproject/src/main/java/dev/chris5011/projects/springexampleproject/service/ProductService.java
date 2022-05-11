package dev.chris5011.projects.springexampleproject.service;

import dev.chris5011.projects.springexampleproject.exception.ProductNotFoundException;
import dev.chris5011.projects.springexampleproject.model.Product;
import dev.chris5011.projects.springexampleproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(int id) {
        Optional<Product> optProduct = productRepository.findById(id);
        if (optProduct.isEmpty()) {
            throw new ProductNotFoundException("Could not find a Product with the id: " + id);
        }
        return optProduct.get();
    }

    public Product addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("The supplied product was null!");
        }

        if (product.getId() != 0) {
            throw new IllegalArgumentException("The supplied Product already has an id! This is not allowed");
        }

        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("The supplied product was null!");
        }

        if (product.getId() == 0) {
            throw new IllegalArgumentException("The supplied Product has no id!");
        }

        return productRepository.save(product);
    }

    public Product deleteProductById(int productId) {
        Optional<Product> optProduct = productRepository.findById(productId);
        if (optProduct.isEmpty()) {
            throw new ProductNotFoundException("Could not find a Product with the id: " + productId);
        }
        Product product = optProduct.get();
        productRepository.delete(product);
        return product;
    }

    public int countProducts() {
        return (int) productRepository.count();
    }

}
