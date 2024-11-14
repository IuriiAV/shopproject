package org.telran.shop.de.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.shop.de.entity.Product;
import org.telran.shop.de.exception.ProductNotFoundException;
import org.telran.shop.de.repository.ProductJpaRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductJpaRepository productRepository;

    //legacy
    //    private ProductRepository productRepository;
    //
    //    @Autowired // Constructor injection
    //    //from spring 4.3 @Autowired with constructor not necessary
    //    public ProductServiceImpl(ProductRepository productRepository) {
    //        this.productRepository = productRepository;
    //    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getByTitle(String title) {
        List<Product> products = productRepository.findAllByTitle(title);
        if (products.isEmpty()) {
            throw new ProductNotFoundException("Product with title " +
                    title + " not found");
        }
        return products.get(0);
    }
}
