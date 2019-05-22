package xtu.bit.learner;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangdi21 on 2019/5/22.
 */
public class FindClass {

    /**
     * 递归找class文件
     * @param allClass
     * @param path
     */
    public void getAllClass(List<String> allClass,String path){
        File file = new File(path);

        if(file.isFile()){
            if(file.getName().endsWith(".class")){
                allClass.add(file.getPath()+"\\"+file.getName().replace(".class",""));
            }
        }else if(file.isDirectory()){
            File[] listFiles = file.listFiles();
            for (File list : listFiles) {
                if (list.isDirectory()) {
                    String tempPath = list.getPath();
                    getAllClass(allClass, tempPath);
                } else if (list.isFile()) {
                    String fileName = list.getName();
                    if (fileName.endsWith(".class")) {
                        allClass.add(file.getPath() + "\\" + fileName.replace(".class", ""));
                    }
                }
            }
        }

    }

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
    public void test(){
        List<String> str = new ArrayList<>();
        getAllClass(str,"D:\\ideaSpace\\Retry\\retry");
        printFile(str);
    }

}
