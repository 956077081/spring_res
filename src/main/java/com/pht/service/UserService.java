package com.pht.service;

import com.pht.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    @Qualifier("useDao2")
    UserDao userDao;
    @Override
    public String toString() {
        return "UserService{" +
                "useDao=" + userDao.getLabel() +
                '}';
    }
}
