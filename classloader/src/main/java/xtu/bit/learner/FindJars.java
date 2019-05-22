package xtu.bit.learner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by zhangdi21 on 2019/5/22.
 */
public class FindJars {
    /**
     * 遍历获取所有的jar路径
     * @param allJars  给出一个初始路径
     * @param path
     */
    public void getAllJars(List<String> allJars,String path){
        File file = new File(path);
        if(file.isFile()){
            if(file.getName().endsWith(".jar")) {
                allJars.add(file.getName());
            }
        }else if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File f:files){
                if(f.isDirectory()){
                    String tempPath = f.getPath();
                    getAllJars(allJars,tempPath);
                }else if(f.isFile()){
                    if(f.getName().endsWith(".jar")) {
                        allJars.add(f.getPath());
                    }
                }
            }
        }
    }

    /**
     * 单个jar包对应的class组成的一个数组
     * @param allJars 所有的jar的路径
     * @return
     * @throws IOException
     */
    public List<List<String>> getAllClass(List<String> allJars) throws IOException {
        List<List<String>> allClass = new ArrayList<>();
        allJars.forEach(jarPath->{
            try {
                List<String> temp = getJarInfo(jarPath);
                allClass.add(temp);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        return allClass;
    }

    /**
     * 根据jar的路径获取所有的class文件
     * @param path
     * @return
     * @throws IOException
     */
    public List<String> getJarInfo(String path) throws IOException{
        JarFile jarFile = new JarFile(path);
        List<String> jarClass = new ArrayList<>();
        Enumeration<JarEntry> entries = jarFile.entries();
        while(entries.hasMoreElements()){
            JarEntry jarEntry = entries.nextElement();
            String fullName = jarEntry.getName();
            if(fullName.indexOf("META-INF")<0){
                //怎么遍历下去？jarEntry已包含所有分支，无需递归，只遍历就可
                if(fullName.endsWith(".class")){
                    jarClass.add(fullName.replace("/",".").replace(".class",""));
                }
            }
        }
        return jarClass;
    }





}
