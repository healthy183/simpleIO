package com.kang.io.demo.inputStream.bufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*BufferedReader相当于一个大桶，其实就是内存，
这里实现了大量大量的读写
，而不是读一个字节或字符就直接写如硬盘，加强了对硬盘的保护。
*/
public class SystemIn {

    public static void main(String[] args) {
        System.out.println("any word:");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        String s = null;
        try {
            while((s = in.readLine()).length() != 0){
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("thread will destroy if 'enter'!");
    }
}
