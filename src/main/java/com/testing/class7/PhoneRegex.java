package com.testing.class7;

import java.util.Scanner;

public class PhoneRegex {
    public static void main(String[] args) {
        System.out.println("请输入要验证的手机号码：");
        //输入
        Scanner phone=new Scanner(System.in);
        for(int i=1;i<=3;i++){
            //输入的值
            String ss=phone.nextLine();
            System.out.println(ss+"验证结果是"+checkPhoneNumber(ss));
        }

    }

    public static boolean checkPhoneNumber(String s){
        //正则表达式验证手机号，第1位为1，第2位是3-7中的任意一个，剩下9位为任意数字
        String reg="1[3-7]\\d{9}";
        return s.matches(reg);


    }
}
