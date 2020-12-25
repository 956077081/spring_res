package com.pht.entity;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;

public class User {
    private String userName;
    private String passWord;

    public User() {
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    @EventListener({ApplicationEvent.class})
    public void testAllListEvent(ApplicationEvent event){
        System.out.println("“User监听的事件");
    }
}
