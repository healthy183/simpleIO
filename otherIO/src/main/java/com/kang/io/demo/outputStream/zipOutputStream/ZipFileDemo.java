package com.kang.io.demo.outputStream.zipOutputStream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/7/31.
 * @Author Healthy
 * @Version
 */
public class ZipFileDemo {

    public static void main(String[] args){
        //zipTxt();
        unZipTxt();
    }

    public static void unZipTxt(){

        File file = new  File("D:/javaio/writeThoughtByte.zip");
        File outFile = new  File("D:/javaio/unZipTxt.txt");
        ZipFile zipFile = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            zipFile = new ZipFile(file);
            ZipEntry zipEntry =  zipFile.getEntry("writeThoughtByte.txt");
            inputStream =  zipFile.getInputStream(zipEntry);
            fileOutputStream = new  FileOutputStream(outFile);
            int temp = 0;
            while((temp = inputStream.read())!= -1){
                fileOutputStream.write(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                    if(fileOutputStream != null){
                        fileOutputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void zipTxt(){

        File wirterFile = new File("D:/javaio/writeThoughtByte.txt");
        File zipFile = new File("D:/javaio/writeThoughtByte.zip");
        FileInputStream fileInputStream = null;
        ZipOutputStream zipOutputStream = null;
        try {
            fileInputStream  = new FileInputStream(wirterFile);
            zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
            zipOutputStream.putNextEntry(new ZipEntry(wirterFile.getName()));
            zipOutputStream.setComment("myFirstZip");
            int temp = 0;
            while((temp = fileInputStream.read())!= -1){
                zipOutputStream.write(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
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
