package com.kang.io.demo.inputStream.bufferedReader;

import java.io.*;

/**
 * Created by Administrator on 2016/7/30.
 */
public class PrintWriterDemo {

    public static void main(String[] args) {
        File fin;
        File fout;
        BufferedReader bf = null;
        PrintWriter pw = null;
        try {
            fin = new File("D:/javaio/in.txt");
            fout = new File("D:/javaio/out.txt");
            bf = new BufferedReader(new FileReader(fin));
            pw = new PrintWriter(fout);
            String line =  bf.readLine();
            while(line != null){
                pw.print(line);
                line =  bf.readLine();
            }
            //pw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException  e) {
            e.printStackTrace();
        }finally {
            if(bf != null){
                try {
                    bf.close();
                    bf = null;
                    if(pw != null){
                        pw.close();
                        pw = null;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
