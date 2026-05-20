package spring_boot.session05ex02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_boot.session05ex02.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
