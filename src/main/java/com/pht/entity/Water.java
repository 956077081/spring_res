package com.pht.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Water  implements InitializingBean, DisposableBean {
    private String  num;
    private String type;
    public void init(){
        System.out.println("init!");
    }
    public void destroybean(){
        System.out.println("destroy!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("inif_init");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("inf _destry");
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
