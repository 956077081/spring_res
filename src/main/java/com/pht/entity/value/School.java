package com.pht.entity.value;

import org.springframework.beans.factory.annotation.Value;

/**
 *value赋值的三种方式
 * 1 直接赋值@VALUE("xxx")
 * 2 spel表达式赋值#{}
 * 3 加载资源文件的方式进行赋值需要 注册bean时进行赋值$
 */
public class School {
    @Value("张三")
    private  String name;
    @Value("#{20-2}")
    private String area;
    @Value("${school.stuNum}")//$方式加载资源文件
    private int  stuNum;

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", stuNum=" + stuNum +
                '}';
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
