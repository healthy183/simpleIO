package com.kang.io.demo.reader.fileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/8/2.
 * @Author Healthy
 * @Version
 */
public class FileReaderDemo {

    public static void main(String[] args) {
        String path = "D:\\javaio\\fileReaderDemo.txt";
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
            //fileReader.read();//每执行一次都向下移动一个字符单位
            //方式1 单字节读取
            /*int context =  fileReader.read();
            System.out.println((char)context);*/

            //优化方式1:循环读取  //文件末会返回-1
           /* StringBuffer stringBuffer  = new StringBuffer();
            int temp = 0;
            while((temp = fileReader.read()) != -1){
                stringBuffer.append((char)temp);
            }
            System.out.println(stringBuffer.toString());*/

            //方式2 读入字符数组
            /*char[] buf = new char[1024];
            int temp = fileReader.read(buf);//返回读取长度
            System.out.println(new String(buf,0,temp));*/

            //优化方式2 //事前不确定文件行数
            char[] buf = new char[1024];
            StringBuffer stringBuffer  = new StringBuffer();
            int temp = 0;
            while((temp = fileReader.read(buf)) != -1){
                stringBuffer.append(new String(buf,0,temp));
            }
            System.out.println(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
