package dev.chris5011.projects.springexampleproject.repository;

import dev.chris5011.projects.springexampleproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
