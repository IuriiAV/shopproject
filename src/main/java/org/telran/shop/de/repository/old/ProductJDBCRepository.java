package org.telran.shop.de.repository.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.telran.shop.de.configuraton.DataBaseManager;
import org.telran.shop.de.enums.ProductType;
import org.telran.shop.de.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@Component
//@Primary
@Deprecated
public class ProductJDBCRepository implements ProductRepository {

    @Autowired
    private DataBaseManager dataBaseManager;

    @Override
    public List<Product> getAll() {
        String sql = "SELECT * FROM products";
        Connection connection = dataBaseManager.getConnection();
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String type = resultSet.getString("type");
                ProductType productType = ProductType.valueOf(type);
                Product product = new Product(title, productType);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product getByTitle(String title) {
        Connection connection = dataBaseManager.getConnection();
        String sql = "SELECT * FROM products WHERE title =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String titleProduct = resultSet.getString("title");
                String type = resultSet.getString("type");
                ProductType productType = ProductType.valueOf(type);
                return new Product(titleProduct, productType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
