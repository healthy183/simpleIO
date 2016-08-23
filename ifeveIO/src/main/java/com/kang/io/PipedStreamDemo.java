package com.kang.io;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by Administrator on 2016/7/30.
 * PipedOutputStream/PipedInputStream管道流io在同进程下不同线程间通信
 * 当使用两个相关联的管道流时，务必将它们分配给不同的线程。
 * read()方法和write()方法调用时会导致流阻塞，
 * 这意味着如果你尝试在一个线程中同时进行读和写，可能会导致线程死锁
 */
@Slf4j
public class PipedStreamDemo {

    public static void main(String[] args) throws IOException {
        try {
            PipedOutputStream  pipedOutputStream = new PipedOutputStream();
            PipedInputStream   pipedInputStream = new PipedInputStream(pipedOutputStream);

            Thread threadOut  = new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        pipedOutputStream.write("my name is tom!".getBytes());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread threadInput  = new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                      int data =  pipedInputStream.read();
                        while (data != -1){
                            System.out.println((char)data);
                            data = pipedInputStream.read();//如输入再读会抛Write end dead
                        }
                    } catch (IOException e) {
                        log.info(Throwables.getStackTraceAsString(e));
                    }
                }
            });
            threadOut.start();
            threadInput.start();
            threadOut.join();
            threadInput.join();
            pipedInputStream.close();
            pipedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
