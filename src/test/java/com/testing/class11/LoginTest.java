package com.testing.class11;

/**
 * @Classname LoginTest
 * @Description 类型说明
 * @Date 2021/2/25 17:04
 * @Created by 小白sy
 */
public class LoginTest {

    public static void main(String[] args) {
        LoginSample ls=new LoginSample();
        //路径覆盖
        //1、用户名为空
        ls.login(null,"123456");


        //2、密码为空
        ls.login("Roy", null);

        //3、用户名长度小于等于2
        ls.login("sy", "123456");

        //4、用户名长度大于等于17
        ls.login("123456789012345678", "123456");


        //5、密码长度小于等于2
        ls.login("Roy","sy");


        //6、密码长度大于等于17
        ls.login("Roy", "123456789012345678");


        //7、用户名是不正确的
        ls.login("syuan", "123456");

        //8、密码是不正确的
        ls.login("roy", "12345645");

        //9、用户名和密码都正确
        ls.login("Roy", "123456");


    }
}
