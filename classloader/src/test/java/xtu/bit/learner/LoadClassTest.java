package xtu.bit.learner;

import org.junit.Test;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by zhangdi21 on 2019/5/23.
 */
public class LoadClassTest {

    String path = "D:\\ideaSpace\\Retry\\retry";
    FindClass findClass = new FindClass();
    LearnerClassloader loader = new LearnerClassloader();

    /**
     * 加载class
     * @throws ClassNotFoundException
     */
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

    /**
     * 用url加载class暂时未调通
     * @throws Exception
     */
    @Test
    public void testURLloadClass() throws Exception{

        String path = "D:\\ideaSpace\\Retry\\retry\\target\\test-classes\\test";

        System.out.println(path);
        URL url = new URL("file:"+path);
        URLClassLoader loader = new URLClassLoader(new URL[]{url});
        Class<?> aClass = loader.loadClass("test.TestBusiness");
        System.out.println(aClass);
    }

    /**
     * 加载jar包
     * @throws Exception
     */
    @Test
    public void testLoadJar() throws Exception{
        String path = "D:\\ideaSpace\\Retry\\retry\\target\\retry-1.0.0-SNAPSHOT.jar";
        URL url = new URL("file:"+path);
        URLClassLoader loader = new URLClassLoader(new URL[]{url});

        JarFile jarFile = new JarFile(path);

        Enumeration<JarEntry> entries = jarFile.entries();
        while(entries.hasMoreElements()){
            JarEntry jarEntry = entries.nextElement();
            String name = jarEntry.getName();
            if(name.indexOf("META-INF")<0){
                if(jarEntry.getName().endsWith(".class")){
                    Class<?> aClass = loader.loadClass(name.replace(".class", "").replace("/","."));
                    System.out.println(aClass);
                }
            }
        }
        System.out.println("-------over-------");
    }
}
