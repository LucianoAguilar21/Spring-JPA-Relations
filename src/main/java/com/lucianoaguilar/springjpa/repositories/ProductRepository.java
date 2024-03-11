package com.lucianoaguilar.springjpa.repositories;

import com.lucianoaguilar.springjpa.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
