package br.com.anthony.api_products.api.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductBaseDTO {
    
    @NotNull
    private Long id;
}
