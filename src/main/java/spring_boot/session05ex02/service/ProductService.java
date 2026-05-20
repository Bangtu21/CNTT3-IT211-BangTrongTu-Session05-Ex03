package spring_boot.session05ex02.service;

import org.springframework.stereotype.Service;
import spring_boot.session05ex02.model.entity.Product;
import spring_boot.session05ex02.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
