package com.saas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saas.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
  List<Customer> findByPublished(boolean published);
  List<Customer> findByTitleContaining(String title);
}
