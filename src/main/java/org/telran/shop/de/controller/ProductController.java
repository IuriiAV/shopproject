package org.telran.shop.de.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telran.shop.de.entity.Product;
import org.telran.shop.de.service.ProductService;

import java.util.List;

//API
//JPA, REST API,

//url - endpoint

// http://localhost:8080

//@Controller
@RestController
@RequestMapping("/api/products") //  http://localhost:8080/api/products
//  server path + port + controller path
public class ProductController {

    @Autowired // Field injection
    private ProductService productService;

    // JSON, XML
    /*
    [
    {
        "title":"Apple",
         "type":"FRUIT"
     },
    {
        "title":"Cucumber",
        "type":"VEGETABLE"
    }
    ]
    */

    @GetMapping //  http://localhost:8080/api/products + GET
    public List<Product> getAll() {
        List<Product> all = productService.getAll();
        return all;
    }

    @GetMapping("/{title}")
    public Product getByTitle(@PathVariable String title) {
        return productService.getByTitle(title);
    }
}
