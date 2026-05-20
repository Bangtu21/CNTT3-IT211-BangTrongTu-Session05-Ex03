package spring_boot.session05ex02.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_boot.session05ex02.model.entity.Product;
import spring_boot.session05ex02.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    protected ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(
            @PathVariable Long id) {

        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /products
    @PostMapping
    public ResponseEntity<Product> createProduct(
            @Valid @RequestBody Product product) {

        Product savedProduct = productService.saveProduct(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedProduct);
    }
}
