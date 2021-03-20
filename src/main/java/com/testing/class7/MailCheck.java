package com.testing.class7;

import java.util.Scanner;

public class MailCheck {
    public static void main(String[] args) {
        System.out.println("请输入要验证的电子邮箱账号");
        Scanner mail=new Scanner(System.in);
        for(int i=1;i<=2;i++) {
            String testMail = mail.nextLine();
            System.out.println("该邮箱的验证结果是" + CheckFun(testMail));
        }
    }
    //邮箱的特征
    //邮箱名@二级域名.一级域名
    //邮箱名可以是：大小写字母、数字、下划线、横杠以及中文字符   [A-Za-z0-9_\\-\ue400-\u9fa5]
    // \ue400-\u9fa5代表Unicode编码中的中文，写在java中要注意转义u
    //二级域名 163 qq sina \\w+
    //三级域名  \\.\\w+{1,2}
    public static boolean CheckFun(String testMail){
        String regex="[A-Za-z0-9_\\-\\u4e00-\\u9fa5]{3,}@(\\w+)(\\.\\w+){1,2}";
        String regex1="[A-Za-z0-9_\\-\\u4e00-\\u9fa5]{3,}@";
        testMail=testMail.replaceAll(regex1, "smtp.");
        System.out.println("替换为smtp服务器后为"+testMail);
        return testMail.matches(regex);
    }

}
