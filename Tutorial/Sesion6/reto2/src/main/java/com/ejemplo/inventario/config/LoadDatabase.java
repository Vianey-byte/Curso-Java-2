package com.ejemplo.inventario.config;

import com.ejemplo.inventario.modelo.Marca;
import com.ejemplo.inventario.modelo.Producto;
import com.ejemplo.inventario.repositorio.MarcaRepository;
import com.ejemplo.inventario.repositorio.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(ProductoRepository productoRepo, MarcaRepository marcaRepo) {
        return args -> {
            Marca apple = marcaRepo.save(new Marca("Apple"));
            Marca samsung = marcaRepo.save(new Marca("Samsung"));

            productoRepo.save(new Producto("iPhone 15", "Smartphone Apple", 20000, apple));
            productoRepo.save(new Producto("iPad Pro", "Tablet Apple", 18000, apple));
            productoRepo.save(new Producto("Galaxy S23", "Smartphone Samsung", 17000, samsung));
            productoRepo.save(new Producto("Smart TV", "Televisor Samsung", 12000, samsung));

            System.out.println("📚 Productos por marca:");
            marcaRepo.findAll().forEach(marca -> {
                System.out.println("🏷️ " + marca.getNombre() + ":");
                productoRepo.findAll().stream()
                    .filter(p -> p.getMarca().getId().equals(marca.getId()))
                    .forEach(p -> System.out.println("   - " + p.getNombre()));
            });
        };
    }
}
