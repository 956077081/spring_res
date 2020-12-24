package com.pht.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserDao {
    @Autowired(required = false)
    private JdbcTemplate jdbcTemplate;

    String label ="1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    @Override
    public String toString() {
        return "UserDao{" +
                "label='" + label + '\'' +
                '}';
    }

    public void insert() {
        String sql ="insert  into user( username,password) values( ?,?)";
        jdbcTemplate.update(sql, UUID.randomUUID().toString().substring(0,5),"123456");
    }
}
