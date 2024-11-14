package org.telran.shop.de.repository.old;

import org.springframework.stereotype.Component;
import org.telran.shop.de.enums.ProductType;
import org.telran.shop.de.entity.Product;

import java.util.Arrays;
import java.util.List;

//@Component
@Deprecated
public class ProductInMemoryRepository implements ProductRepository {

    private List<Product> storage = Arrays.asList(
            new Product("Apple", ProductType.FRUIT),
            new Product("Cucumber", ProductType.VEGETABLE),
            new Product("Pineapple", ProductType.FRUIT)
    );

    @Override
    public List<Product> getAll() {
        return storage;
    }

    @Override
    public Product getByTitle(String title) {
        return null;
    }
}
