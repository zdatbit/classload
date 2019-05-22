package xtu.bit.learner;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangdi21 on 2019/5/22.
 */
public class FindJarsTest {

    /**
     * 打印获取的jar名
     * @param allClass
     */
    public void printJarName(List<String> allClass){
        allClass.forEach(clazz->{
            System.out.println(clazz);
        });
    }

    @Test
    public void test() throws Exception{
        FindJars findJars = new FindJars();
        List<String> allJars = new ArrayList<>();
        findJars.getAllJars(allJars,"D:\\ideaSpace\\Retry\\retry\\target");
        printJarName(allJars);

        List<List<String>> allClass = findJars.getAllClass(allJars);
        for(List<String> list:allClass){
            for(String li:list){
                System.out.println(li);
//                Class<?> aClass = Thread.currentThread().getContextClassLoader().loadClass(li);
//                System.out.println(aClass);
            }
        }
    }
}
