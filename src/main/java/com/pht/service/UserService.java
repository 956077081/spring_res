package com.pht.service;

import com.pht.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
//    @Qualifier("useDao2")
    private  UserDao userDao;
    @Override
    public String toString() {
        return "UserService{" +
                "useDao=" + userDao.getLabel() +
                '}';
    }

    @Transactional
    public  void insertUser(){
        userDao.insert();
        System.out.println("插入完成！");
        int i =1/0;
    }
}
