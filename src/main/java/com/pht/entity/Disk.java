package com.pht.entity;

import javax.xml.bind.annotation.XmlEnum;

public class Disk {
    private  String code="1";
    private  String position;

    public Disk() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
