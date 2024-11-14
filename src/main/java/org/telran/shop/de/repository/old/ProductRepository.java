package org.telran.shop.de.repository.old;

import org.telran.shop.de.entity.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAll();

    Product getByTitle(String title);
}
