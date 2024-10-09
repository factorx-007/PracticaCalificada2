package com.example.PracticaC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.PracticaC.models.Producto;

@Repository
public interface ProductsRepository extends JpaRepository<Producto, Long> {
}
