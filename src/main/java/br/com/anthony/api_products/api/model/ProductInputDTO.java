package br.com.anthony.api_products.api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductInputDTO {
    
    private static final int SIZE_MIN_NAME = 5;
    private static final int SIZE_MAX_NAME = 60;
    private static final int SIZE_MIN_PRICE = 2;
    private static final int SIZE_MAX_PRICE = 6; 
    private static final int SIZE_MAX_BRAND = 60;
    private static final int SIZE_MIN_BRAND = 2;
    private static final int SIZE_MAX_CATEGORY = 60;
    private static final int SIZE_MIN_CATEGORY = 2;  

    @NotBlank
    @Size(min = SIZE_MIN_NAME, max = SIZE_MAX_NAME)
    private String name;

    @NotBlank
    @Size(min = SIZE_MIN_PRICE, max = SIZE_MAX_PRICE)
    private String price;

    @NotBlank
    @Size(min = SIZE_MIN_BRAND, max = SIZE_MAX_BRAND)
    private String brand;

    @NotBlank
    @Size(min = SIZE_MIN_CATEGORY, max = SIZE_MAX_CATEGORY)
    private String category;
}
