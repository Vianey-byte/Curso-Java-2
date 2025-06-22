package com.ejemplo.inventario.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ejemplo.inventario.modelo.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {}
