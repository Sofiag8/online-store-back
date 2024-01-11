package com.example.onlinestoreback.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinestoreback.Entity.Product;
import com.example.onlinestoreback.ErrorHandler.NotFoundException;
import com.example.onlinestoreback.ErrorHandler.ResourceNotFoundException;
import com.example.onlinestoreback.Repository.ProductRepository;

@Service
public class ProductService {
  private final ProductRepository productRepository;


  @Autowired
  public ProductService(ProductRepository productRepository) {
      this.productRepository = productRepository;
  }

  public List<Product> findAllProducts() {
    List<Product> products = productRepository.findAll();
    if (products.isEmpty()) throw new NotFoundException("when searching for products");
    return products;
  }

  public Product createProduct(Product product) {
    return productRepository.save(product);
  }

  public Product findProductById(Long id) {
    return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public Product updateProductById(Long id, Product productToUpdate) {
    if (productRepository.existsById(id)) {
      productToUpdate.setId(id);
      return productRepository.save(productToUpdate);
    }
  return null;
  }

  public void deleteProduct(long id) {
    productRepository.deleteById(id);
  }
}
