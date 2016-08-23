package com.kang.io.demo.outputStream.zipOutputStream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/7/31.
 * @Author Healthy
 * @Version
 */
public class ZipMultiFile {


    public static void main(String[] args){
        //zipMulti();
        unzipMulti();
    }

    public static void unzipMulti(){
        File sourceFile = new File("D:/bin/bin.zip");
        File outFile = null;
        ZipInputStream inputStream = null;
        ZipEntry zipEntry = null;
        InputStream inputStreamFile =  null;
        OutputStream outputStream = null;
        try {
            ZipFile zipFile = new ZipFile(sourceFile);
            inputStream =  new ZipInputStream(new FileInputStream(sourceFile));
            while ((zipEntry = inputStream.getNextEntry()) != null ){
                System.out.println("解压文件:"+zipEntry.getName());
                outFile = new File("D:/bin/newBin/"+zipEntry.getName());
                if(!outFile.getParentFile().exists()){
                    outFile.getParentFile().mkdir();
                }
                if(!outFile.exists()){
                    outFile.createNewFile();
                }
                inputStreamFile =  zipFile.getInputStream(zipEntry);
                outputStream = new FileOutputStream(outFile);
                int temp = 0;
                while((temp = inputStreamFile.read()) != -1){
                    outputStream.write(temp);
                }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                    inputStreamFile.close();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void zipMulti(){

        File folder = new File("D:/bin/");
        File zipFile = new File("D:/bin/bin.zip");
        InputStream inputStream = null;
        ZipOutputStream zipOutputStream = null;

        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
            zipOutputStream.setComment("zipMultiFile");
            if(folder.isDirectory()){
                File[] files =  folder.listFiles();
                for(int i = 0;i<files.length;i++){
                    inputStream = new FileInputStream(files[i]);
                    zipOutputStream.putNextEntry(new ZipEntry(folder.getName()+File.separator+files[i].getName()));
                    int temp = 0;
                    while((temp = inputStream.read())!= -1 ){
                        zipOutputStream.write(temp);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                    if(zipOutputStream != null){
                        zipOutputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
