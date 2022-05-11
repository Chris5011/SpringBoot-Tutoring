package dev.chris5011.projects.springexampleproject.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "product")
public class Product implements Serializable {

    @Id
    @Column(name = "prod_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "prod_name")
    private String productName;

    @Column(name = "prod_price")
    private double price;

    public Product() {
    }

    public Product(int id, String productName, double price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", productName='" + productName + ", price=" + price + '}';
    }
}
