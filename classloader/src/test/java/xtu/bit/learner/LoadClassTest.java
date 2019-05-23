package xtu.bit.learner;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangdi21 on 2019/5/23.
 */
public class LoadClassTest {

    String path = "D:\\ideaSpace\\Retry\\retry";
    FindClass findClass = new FindClass();
    LearnerClassloader loader = new LearnerClassloader();

    @Test
    public void testLoadClass() throws ClassNotFoundException{
        //获取所有的class
        List<String> classNames = new ArrayList<>();
        findClass.getAllClass(classNames,path);

        for(String name:classNames){
            System.out.println(name);
            Class<?> aClass = loader.loadClass(name);
            System.out.println(aClass);
        }
    }
}
