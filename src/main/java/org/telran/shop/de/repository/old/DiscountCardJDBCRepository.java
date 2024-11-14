package org.telran.shop.de.repository.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.telran.shop.de.entity.DiscountCard;

import java.util.List;

//@Repository("dcrepository")
@Deprecated
public class DiscountCardJDBCRepository implements DiscountCardRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<DiscountCard> getAll() {
        String sql = "SELECT * FROM discount_card";
        List<DiscountCard> result = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<DiscountCard>(DiscountCard.class));
        return result;
    }

    @Override
    public DiscountCard create(DiscountCard card) {
        return null;
    }

    @Override
    public DiscountCard getById(String id) {
        String sql = "SELECT * FROM discount_card WHERE id =?";
        List<DiscountCard> result = jdbcTemplate.query(sql,
                new Object[]{id},
                new BeanPropertyRowMapper<>(DiscountCard.class));
        return result.size() > 0 ? result.get(0) : null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void setExpired(String id) {

    }

    @Override
    public List<DiscountCard> filter(boolean expired) {
        return null;
    }
}
