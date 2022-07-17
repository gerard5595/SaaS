package com.saas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saas.entity.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
  List<Manufacturer> findByPublished(boolean published);
  List<Manufacturer> findByTitleContaining(String title);
}
