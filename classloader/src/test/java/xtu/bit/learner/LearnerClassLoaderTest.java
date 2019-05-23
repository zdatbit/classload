package xtu.bit.learner;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by zhangdi21 on 2019/5/23.
 */
public class LearnerClassLoaderTest {

    String path = "D:\\ideaSpace\\allTest\\target\\classes\\Test\\";
    LearnerClassloader loader = new LearnerClassloader();

    @Test
    public void testGetBytes() throws IOException{

        String name = "ClassTest";
        byte[] bytes = loader.getBytesByPath(path+name);
        System.out.println(bytes.length);
    }

    @Test
    public void testLoad() throws ClassNotFoundException{
        Class<?> classTest = loader.findClass(path+"ClassTest");
        System.out.println(classTest.getName());
    }

}
