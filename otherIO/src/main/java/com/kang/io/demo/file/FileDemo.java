package com.kang.io.demo.file;

import java.io.File;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/8/2.
 * @Author Healthy
 * @Version
 */
public class FileDemo {

    public static void main(String[] args) {
        File f = new File("D:/javaio/file.txt");
        try{
            f.createNewFile();
        }catch(Exception ex){
        }
        System.out.println(f.separator);
        System.out.println(f.pathSeparator);

        f.delete();

        File javaio = new File("D:/javaio");
        String[] str = javaio.list();
        for(String fileName : str){
            //System.out.println(fileName);
        }
        File[]  fileList =  javaio.listFiles();
        for(File thisFile : fileList){
            System.out.println(thisFile.getName());
        }

        System.out.println(javaio.isDirectory());

    }
}
