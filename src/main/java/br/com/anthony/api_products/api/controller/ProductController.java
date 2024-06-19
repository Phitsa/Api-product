package br.com.anthony.api_products.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.anthony.api_products.api.model.ProductInputDTO;
import br.com.anthony.api_products.api.model.ProductOutDTO;
import br.com.anthony.api_products.assembler.ProductAssembler;
import br.com.anthony.api_products.domain.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    
    private ProductAssembler productAssembler;
    private ProductService productService;
    private static final String deleteprint = "dado deletado com sucesso";

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductOutDTO getMethodName(@RequestBody final @Valid ProductInputDTO productInputDTO) {
        return productAssembler.toDto(productService.register(productAssembler.toProduct(productInputDTO)));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductOutDTO> update(@PathVariable final @NotNull Long productId,
            @RequestBody @Valid final ProductInputDTO productInputDTO) {
            
        return ResponseEntity
                .ok(productAssembler.toDto(productService.update(productAssembler.toProduct(productInputDTO), productId)));
    }

    @GetMapping("/{productId}")
    public ProductOutDTO consult(@PathVariable final @NotNull Long productId) {
        return productAssembler.toDto(productService.search(productId));
    }
    
    @GetMapping("/list")
    public List<ProductOutDTO> list() {
        return productAssembler.toCollectionDto(productService.list());   
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> delete(@PathVariable @NotNull Long productId) {
        productService.delete(productId);
        return new ResponseEntity<String>(deleteprint, HttpStatus.OK);
    }
}