package br.com.anthony.api_products.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.anthony.api_products.api.model.ProductInputDTO;
import br.com.anthony.api_products.api.model.ProductOutDTO;
import br.com.anthony.api_products.domain.model.Product;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ProductAssembler {

    private ModelMapper modelMapper;

    public Product toProduct(final ProductInputDTO productInputDTO) {
        return modelMapper.map(productInputDTO, Product.class);
    }

    public ProductOutDTO toDto(final Product product) {
        return modelMapper.map(product, ProductOutDTO.class);
    }

    public List<ProductOutDTO> toCollectionDto(final List<Product> people) {
        return people.stream().map(this::toDto).collect(Collectors.toList());
    }
}
