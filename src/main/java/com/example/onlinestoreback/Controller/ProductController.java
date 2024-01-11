package com.example.onlinestoreback.Controller;

import com.example.onlinestoreback.Entity.Product;
import com.example.onlinestoreback.Service.ProductService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAllProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addProduct(@Valid @RequestBody Product product) {        
        productService.createProduct(product);
        return "ok";
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return  productService.findProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updateProduct) {
       return productService.updateProductById(id, updateProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}