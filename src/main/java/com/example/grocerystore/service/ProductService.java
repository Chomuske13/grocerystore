package com.example.grocerystore.service;

import com.example.grocerystore.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ProductService {

    private final List<Product> productList;

    public ProductService() {
        this.productList = new ArrayList<>();
        productList.add(new Product(1L, "Apple", 0.99));
        productList.add(new Product(2L, "Banana", 1.29));

    }


    public Optional<Product> getProductById(Long id) {
        return productList.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    public List<Product> getProductsByName(String name) {
        List<Product> products = productList.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .toList();
        if (products.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No products found with this name");
        }
        return products;
    }
}
