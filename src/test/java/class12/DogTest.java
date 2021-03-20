package class12;

import com.testing.class12.Dog;

/**
 * @Classname DogTest
 * @Description 类型说明
 * @Date 2021/2/26 21:21
 * @Created by 小白sy
 */
public class DogTest {
    public static void main(String[] args) {
        Dog dog=new Dog("贝贝");
        dog.bark();

        String name="roy";
        switch (name){
            case "roy":
                System.out.println(name);
                break;
            case "will":
                System.out.println(name);
                break;
        }
    }

}
