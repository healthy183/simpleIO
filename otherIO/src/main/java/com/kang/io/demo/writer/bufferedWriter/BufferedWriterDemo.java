package com.kang.io.demo.writer.bufferedWriter;

import java.io.*;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/8/2.
 * @Author Healthy
 * @Version
 */
public class BufferedWriterDemo {

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileInputStream =  new FileInputStream("D:/javaio/bufferedWriterDemo.txt");
            reader = new BufferedReader(new InputStreamReader(fileInputStream));
            outputStreamWriter = new OutputStreamWriter( new FileOutputStream("D:/javaio/bufferedWriterOut.txt"));
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            String buf = null;
            while((buf = reader.readLine()) != null){
                bufferedWriter.write(buf);
                bufferedWriter.newLine();
                System.out.println(buf);
            }
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                    if(reader != null){
                        reader.close();
                    }
                    if(outputStreamWriter != null){
                        outputStreamWriter.close();
                    }
                    if(bufferedWriter != null){
                        bufferedWriter.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
