package com.testing.class7;

public class RegexLearn {
    public static void main(String[] args) {
        String roy="roy老师";
        String will="will老师";
        String tufei="土匪.老师";
        String kaka="kaka";
        String dian="y.老师";
        String gang="\\老师";
//        System.out.println(dian);
//        System.out.println(gang);
        String youmi="悠米.老师";
        String omi="o米老师";
        String royroy="royroy老师";


        //正则表达式
        //.用于匹配时表示单个字符
        String teacher1="....老师";
        //\\D非数字的字符匹配
        String teacher2="\\D\\D\\D\\D老师";
        //匹配一个包含\\字符的
        String teacher3="\\\\老师";
        //匹配包含.字符的
        String teacher4=".\\.老师";
        //组合元字符+量词,表示，取三次值，范围是r/o/y/悠/米/./\这七个字符，这三个可以重复也可以不重复
        String teacher5="r[roy悠米.\\\\]{1,3}老师";
        //roy正好出现两次
        String roydouble="(roy){2}";
//        System.out.println(roy+"匹配结果是"+roy.matches(roydouble));
//        System.out.println(will+"匹配结果是"+will.matches(roydouble));
//        System.out.println(tufei+"匹配结果是"+tufei.matches(roydouble));
//        System.out.println(kaka+"匹配结果是"+kaka.matches(roydouble));
//        System.out.println(youmi+"匹配结果是"+youmi.matches(roydouble));
//        System.out.println(gang+"匹配结果是"+gang.matches(roydouble));
//        System.out.println(omi+"匹配结果是"+omi.matches(roydouble));
        System.out.println(royroy+"匹配结果是"+royroy.matches(roydouble));
//        System.out.println("-----.匹配结果");
//        System.out.println(roy.matches(teacher1));
//        System.out.println(will.matches(teacher1));
//
//        System.out.println("-----\\D匹配结果");
//        System.out.println(roy.matches(teacher2));
//        System.out.println(will.matches(teacher2));
//
//        System.out.println("-----\\\\匹配结果");
//        System.out.println(gang.matches(teacher3));
//        System.out.println("-----\\.匹配结果");
//        System.out.println(dian.matches(teacher4));



    }
}
