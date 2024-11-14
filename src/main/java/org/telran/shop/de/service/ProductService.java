package org.telran.shop.de.service;

import org.telran.shop.de.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product getByTitle(String title);
}
