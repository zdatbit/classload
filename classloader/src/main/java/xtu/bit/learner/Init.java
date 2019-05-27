package xtu.bit.learner;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangdi21 on 2019/5/22.
 */
public class Init {

    String path = "D:\\ideaSpace\\fbcheck-worker-job";

    List<String> classPathAndName = new ArrayList<>();

    List<String> jarPath = new ArrayList<>();

    LearnerClassloader loader = new LearnerClassloader();
    FindClass findClass = new FindClass();
    FindJars findJars = new FindJars();

    @Test
    public void run() throws ClassNotFoundException{
        findClass.getAllClass(classPathAndName,path);

        findJars.getAllJars(jarPath,path);

        for(String name:classPathAndName){
            loader.loadClass(name);
        }
    }


}
