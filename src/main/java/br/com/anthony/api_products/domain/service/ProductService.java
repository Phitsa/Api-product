package br.com.anthony.api_products.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.anthony.api_products.domain.model.Product;
import br.com.anthony.api_products.domain.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductService {
    
    private ProductRepository productRepository;
    
    @Transactional
    public Product register(final Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public Product update(final Product product, Long productId ) {
        
        Product findProduct = search(productId);
        findProduct.setName(product.getName());
        findProduct.setPrice(product.getPrice());
        findProduct.setBrand(product.getBrand());
        findProduct.setCategory(product.getCategory());

        return productRepository.save(findProduct);
    }

    @Transactional
    public Product search(final Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    @Transactional
    public List<Product> list() {
        return productRepository.findAll();
    }

    @Transactional
    public void delete(Long productId){
        productRepository.deleteById(productId);
    };
}
