package com.pht.Beanfactory;

import com.pht.entity.House;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;

public class HouseFactoryBean implements FactoryBean<House> {
    @Override
    public House getObject() throws Exception {
        return new House();
    }

    @Override
    public Class<?> getObjectType() {
        return House.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
