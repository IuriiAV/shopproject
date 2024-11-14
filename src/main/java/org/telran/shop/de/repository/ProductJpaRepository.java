package org.telran.shop.de.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telran.shop.de.entity.Product;

import java.util.List;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByTitle(String title);
}
