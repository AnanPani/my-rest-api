package com.example.my_rest_api.controller;

import com.example.my_rest_api.model.Product;
import com.example.my_rest_api.repository.ProductRepository; // Import the new repository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository; // Use the repository

    // Inject ProductRepository via constructor
    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // --- API Endpoints ---

    // GET: ดึงข้อมูลสินค้าทั้งหมด
    // URL: GET /api/products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll(); // Fetches all products from the database
    }

    // GET: ดึงข้อมูลสินค้าตาม ID
    // URL: GET /api/products/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Handle product not found
    }

    // POST: สร้างสินค้าใหม่
    // URL: POST /api/products
    // Request Body: JSON ของ Product
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productRepository.save(product); // Saves the new product to the database
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // PUT: อัปเดตสินค้าที่มีอยู่
    // URL: PUT /api/products/{id}
    // Request Body: JSON ของ Product ที่มีข้อมูลที่ต้องการอัปเดต
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(updatedProduct.getName());
                    existingProduct.setPrice(updatedProduct.getPrice());
                    return new ResponseEntity<>(productRepository.save(existingProduct), HttpStatus.OK); // Updates and
                                                                                                         // saves
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE: ลบสินค้า
    // URL: DELETE /api/products/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id); // Deletes from the database
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}