package com.testing.class12;

/**
 * @Classname Dog
 * @Description 类型说明
 * @Date 2021/2/26 20:59
 * @Created by 小白sy
 */
public class Dog {
    private String name;
    public  Dog(String name){
        this.name=name;
    }
    public void bark(){
        System.out.println(name+"汪汪叫");
    }
}
