package br.com.anthony.api_products.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anthony.api_products.domain.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
