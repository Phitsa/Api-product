package br.com.anthony.api_products.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOutDTO extends ProductBaseDTO{
    
    private String name;
    private String price;
    private String brand;
    private String category;

}
