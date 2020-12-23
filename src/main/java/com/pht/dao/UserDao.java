package com.pht.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
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
}
