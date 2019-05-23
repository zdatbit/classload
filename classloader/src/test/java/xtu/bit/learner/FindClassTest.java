package xtu.bit.learner;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangdi21 on 2019/5/22.
 */
public class FindClassTest {

    /**
     * 加载的class全限定名打印出来
     * @param stringList
     */
    public void printFile(List<String> stringList){
        stringList.forEach(str->{
            System.out.println(str);
        });
    }


    /**
     * 测试
     */
    @Test
    public void run(){
        FindClass findClass = new FindClass();
        Map<String,String> str = new HashMap<>();
        findClass.getAllClass(str,"D:\\ideaSpace\\Retry\\retry");
        str.forEach((path,name)->{

        });
    }
}
