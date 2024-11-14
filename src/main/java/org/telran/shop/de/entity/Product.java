package org.telran.shop.de.entity;

import jakarta.persistence.*;
import org.telran.shop.de.enums.ProductType;

@Entity
@Table(name = "products")
public class Product {

    @Id // данное поле является первичным ключом
    @GeneratedValue(strategy = GenerationType.IDENTITY) // авто увеличение поля
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    public Product(String title, ProductType type) {
        this.title = title;
        this.type = type;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", type=" + type +
                '}';
    }
}
