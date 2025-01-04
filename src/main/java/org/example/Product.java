package org.example;

import jakarta.persistence.*;
import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl;

import java.time.LocalDateTime;

@Entity

public class Product {
    @Id
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private String quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Product() {
    }

    public Product(Long id, String name, String description, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }

   //DriverManagerConnectionProviderImpl

// class_name.hbm.xml


}
