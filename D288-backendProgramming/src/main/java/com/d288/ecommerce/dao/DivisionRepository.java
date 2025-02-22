package com.d288.ecommerce.dao;

import com.d288.ecommerce.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface DivisionRepository extends JpaRepository<Division, Long> {
}
