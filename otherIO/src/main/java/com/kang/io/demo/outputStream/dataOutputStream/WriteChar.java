package com.kang.io.demo.outputStream.dataOutputStream;

import java.io.*;

/**
 * @Title 类名
 * @Description  乱码……
 * @Date 2016/7/31.
 * @Author Healthy
 * @Version
 */
public class WriteChar {

    public static void main(String[] args) {

        File wirterFile = new File("D:/javaio/writeChar.txt");
        char[] ch = { 'A', 'B', 'C' };
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new FileOutputStream(wirterFile));
            for(char temp : ch){
                out.writeChar(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out != null){
                try {
                    out.close();
                    out = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
