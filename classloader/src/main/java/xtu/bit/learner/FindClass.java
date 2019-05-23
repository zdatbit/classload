package xtu.bit.learner;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangdi21 on 2019/5/22.
 */
public class FindClass {

    /**
     * 递归找class文件
     * @param allClass    map，key存放class的路径，vlaue存放class的名
     * @param path        初始路径
     */
    public void getAllClass(Map<String,String> allClass, String path){
        File file = new File(path);

        if(file.isFile()){
            if(file.getName().endsWith(".class")){
                allClass.put(file.getPath(),file.getName());
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
                        allClass.put(file.getPath(),fileName);
                    }
                }
            }
        }

    }


    /**
     * 递归找class文件
     * @param allClass   存放所有class名的数组
     * @param path       初始路径
     */
    public void getAllClass(List<String> allClass, String path){
        File file = new File(path);

        if(file.isFile()){
            if(file.getName().endsWith(".class")){
                allClass.add(file.getPath()+"\\"+file.getName());
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
                        allClass.add(file.getPath()+"\\"+fileName);
                    }
                }
            }
        }

    }


}
