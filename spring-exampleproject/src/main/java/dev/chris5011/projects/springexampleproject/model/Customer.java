package dev.chris5011.projects.springexampleproject.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private int id;

    @Column(name = "cust_firstname")
    private String firstName;

    @Column(name = "cust_lastname")
    private String lastName;

    @Column(name = "cust_birthdate")
    private LocalDate birthdate;

    @Column(name = "cust_country")
    private String country;

    @ManyToOne
    private Product favouriteProduct;

    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, LocalDate birthdate, String country, Product product) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.country = country;
        this.favouriteProduct = product;
    }

    public Customer(String firstName, String lastName, LocalDate birthdate, String country, Product product) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.country = country;
        this.favouriteProduct = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Product getFavouriteProduct() {
        return favouriteProduct;
    }

    public void setFavouriteProduct(Product favouriteProduct) {
        this.favouriteProduct = favouriteProduct;
    }

    @Override
    public String toString() {
        return "Customer (" + id + ") : " + firstName + " " + lastName + " has birthday on: " + birthdate + " and is from: " + country + ". The favourite Product is: " + favouriteProduct.getProductName();
    }
}
