package xtu.bit.learner;

import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by zhangdi21 on 2019/5/24.
 */
public class JarClassLoad {

    private List<String> allJarPaths = new ArrayList<>();
    private FindJars findJars = new FindJars();

    public void loadJar(String path) throws Exception{
        URL url = new URL("file:"+path);
        URLClassLoader loader = new URLClassLoader(new URL[]{url});
        File file = new File(path);
        JarFile jarFile = new JarFile(file);
        Enumeration<JarEntry> entries = jarFile.entries();
        while(entries.hasMoreElements()){
            JarEntry jarEntry = entries.nextElement();
            if(jarEntry.getName().indexOf("META-INF")<0){
                if(jarEntry.getName().endsWith(".class")) {
                    String className = jarEntry.getName().replace("/", ".").replace(".class", "");
                    System.out.println(className);
                    loader.loadClass(className);
                }
            }
        }
    }

    public void getAlljarsPath(List<String> jarPath,String path) throws Exception{
        File file = new File(path);
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File file1:files){
                if(file1.isDirectory()){
                    getAlljarsPath(jarPath,file1.getPath());
                }else if(file1.isFile()){
                    if(file1.getName().endsWith(".jar")) {
                        jarPath.add(file1.getPath());
                    }
                }
            }
        }else if(file.isFile()){
            if(file.getName().endsWith(".jar")) {
                jarPath.add(file.getPath());
            }
        }
    }

    @Test
    public void run() throws Exception{
        List<String> jarPath = new ArrayList<>();
        getAlljarsPath(jarPath,"D:\\ideaSpace\\com.bj58.fang.broker.inspect\\com.bj58.fang.broker.inspect.service\\target");
        for(String path:jarPath) {
            loadJar(path);
        }
    }

}
