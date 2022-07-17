package com.saas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saas.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByPublished(boolean published);
  List<Product> findByTitleContaining(String title);
}

