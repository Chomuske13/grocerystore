package com.example.grocerystore.controller;

import com.example.grocerystore.model.Product;
import com.example.grocerystore.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(@RequestParam(value = "name", required = false) String name) {
        if (name != null) {
            return productService.getAllProducts().stream()
                    .filter(product -> product.getName().equalsIgnoreCase(name))
                    .toList();
        }
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}
