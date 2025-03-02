package com.example.grocerystore.service;

import com.example.grocerystore.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public ProductService() {
        // Инициализация некоторых данных
        products.add(new Product(1L, "Apple", 0.99));
        products.add(new Product(2L, "Banana", 1.29));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
    }
}
