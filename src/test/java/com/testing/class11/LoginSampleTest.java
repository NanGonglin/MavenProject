package com.testing.class11;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * @Classname LoginSampleTest
 * @Description 类型说明
 * @Date 2021/2/25 19:29
 * @Created by 小白sy
 */
public class LoginSampleTest {

    //由于被测类的对象所有方法都要用，所以使用成员变量
    private static LoginSample ls;

    @BeforeClass
    public static void BeforeClass() {
        //整个测试类执行之前都会执行的方法
        System.out.println("***********测试用例执行之前执行的@BeforeClass内容***********");
        //将被测的实例化操作放到set up里面
        ls = new LoginSample();
    }


    @AfterClass
    public static void AfterClass() {
        //整个测试类执行之后都会执行的方法
        System.out.println("***********测试用例执行之后执行的@AfterClass内容***********");
    }


    @Before
    public void setUp() throws Exception {
        //在@Before中的内容，是在每个测试方法执行之前都会执行的内容，所以有多个测试方法时，会不断被初始化，实例化就会出现问题
        System.out.println("-------------测试用例执行之前执行的@before内容-----------------");
        //将被测的实例化操作放到set up里面
//        ls=new LoginSample();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("-------------测试用例执行之后执行的@after内容-----------------");
    }

    @Test
    public void loginNormal() {
        ls.login("Roy", "123456");
        //断言，判断测试用例执行是否正确
        Assert.assertTrue(ls.getResultMSG().contains("恭喜您"));
    }
    @Test
    public void loginUseNull(){
        ls.login(null, "123456");
        Assert.assertEquals("用户名为空的测试用例！","用户名密码不能为空！", ls.getResultMSG());
    }

    @Test
    public void getResultMSG() {
        System.out.println("获取测试方法的结果调用"+ls.getResultMSG());

        Assert.fail("把这个测试用例结果认为是失败的吧");;
    }
}