package com.testing.class11;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

/**
 * @Classname LoginDataTest
 * @Description 类型说明
 * @Date 2021/2/25 22:41
 * @Created by 小白sy
 */
@RunWith(Parameterized.class)

public class LoginDataTest {
    //声明被测类对象ls
    public static LoginSample ls;
    //声明数据驱动数据username和password
    //用于接收@parameters方法返回的每一行元素的数据，并且供@test测试方法使用
    private  String username;
    private  String password;

    @BeforeClass
    public static void newLogin() {
        ls = new LoginSample();
    }

    //构造方法完成对成员变量的赋值操作,构造方法中，定义和二维数据每一行的元素对应得参数列表
    public LoginDataTest(String ln, String pwd) {
        username = ln;
        password = pwd;
    }

    @Test
    public void login() {
        ls.login(username, password);
    }


    @Parameterized.Parameters
    //类必须是二维数组
    public static Object[][] logindata() {
        Object[][] data = new Object[][]{
                {null, "123456"},
                {"Roy", null},
                {"sy", "123456"}


        };
        return data;
    }
}