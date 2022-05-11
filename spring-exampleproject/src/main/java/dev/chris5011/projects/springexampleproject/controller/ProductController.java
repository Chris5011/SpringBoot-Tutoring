package dev.chris5011.projects.springexampleproject.controller;

import dev.chris5011.projects.springexampleproject.model.Product;
import dev.chris5011.projects.springexampleproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/listAll")
    public List<Product> listAllProducts(){
        return productService.listAllProducts();
    }

    @GetMapping("/id/{id}")
    public Product findProductById(@PathVariable int id){
        return productService.findProductById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product newProduct = productService.addProduct(product);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id/{id}")
                .build(newProduct.getId())).body(newProduct);
    }

    @PutMapping("/")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/id/{id}")
    public Product deleteProduct(@PathVariable int id){
        return productService.deleteProductById(id);
    }

    @GetMapping("/count")
    public int getProductCount(){
        return productService.countProducts();
    }
}
