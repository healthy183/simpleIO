package com.kang.io.demo.inputStream.sequenceInputStream;

import java.io.*;

/**
 * @Title 类名
 * @Description 将两个文本文件合并为另外一个文本文件
 * @Date 2016/8/1.
 * @Author Healthy
 * @Version
 */
public class SequenceInputStreamDemo {

    public static void main(String[] args) {


        File sourceA = new File("D:/bin/a.txt");
        File sourceB = new File("D:/bin/b.txt");
        File sourceAB = new File("D:/bin/ab.txt");
        InputStream inputStreamA = null;
        InputStream inputStreamB = null;
        FileOutputStream fileOutputStream = null;
        SequenceInputStream sequenceInputStream = null;
        try {
             inputStreamA = new FileInputStream(sourceA);
             inputStreamB = new FileInputStream(sourceB);
             fileOutputStream = new FileOutputStream(sourceAB);
             sequenceInputStream = new SequenceInputStream(inputStreamA,inputStreamB);
            int temp = 0;
            while((temp = sequenceInputStream.read()) != -1 ){
                fileOutputStream.write(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
                if(inputStreamA != null){
                    try {
                        inputStreamA.close();
                        if(inputStreamB != null){
                            inputStreamB.close();
                        }
                        if(fileOutputStream != null){
                            fileOutputStream.close();
                        }
                        if(sequenceInputStream != null){
                            sequenceInputStream.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }

    }
}
