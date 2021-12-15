package com.quartz;

import org.quartz.Job;

import java.io.UnsupportedEncodingException;

public class TestMain1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Myjob myjob = new Myjob();
         if(myjob.getClass().isInterface()){
             System.out.println("1212");
         }
    }
}
