package com.kang.io.demo.outputStream.pipedOutputStream;

import com.google.common.base.Throwables;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/7/31.
 * @Author Healthy
 * @Version
 */

class Send implements Runnable{

    private PipedOutputStream pipedOutputStream = null;

    public Send(){
        pipedOutputStream = new PipedOutputStream();
    }

    public PipedOutputStream getOut(){
        return this.pipedOutputStream;
    }

    @Override
    public void run() {
        String msg = "Hi, i am tom!";

        try {
            pipedOutputStream.write(msg.getBytes());
        } catch (IOException e) {
            Throwables.getStackTraceAsString(e);
        }finally {
            try{
                pipedOutputStream.close();
            }catch (Exception ex){
                Throwables.getStackTraceAsString(ex);
            }
        }
    }
}

class Recive implements  Runnable{

    private PipedInputStream pipedInputStream =null;

    public  Recive(){
        pipedInputStream = new PipedInputStream();
    }

    public PipedInputStream getInput(){
        return  pipedInputStream;
    }
    @Override
    public void run() {
        byte[] b = new byte[1000];
        int len = 0;
        try {
            len = pipedInputStream.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(pipedInputStream != null){
                try {
                    pipedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("recive data:"+new String(b,0,len));
    }
}

public class PipedOutputStreamDemo {
    public static void main(String[] args) {
        Send send = new Send();
        Recive recive =  new Recive();
        try {
            send.getOut().connect(recive.getInput());
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(send).start();
        new Thread(recive).start();
    }

}
