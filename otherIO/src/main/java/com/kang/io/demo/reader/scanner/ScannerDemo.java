package com.kang.io.demo.reader.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/8/1.
 * @Author Healthy
 * @Version
 */
public class ScannerDemo {

    public static void main(String[] args) {
        //systemIn();
        file();
    }

    public static void file(){
        File file  = new File("D:/javaio/printStreamSystem.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            String str = scanner.next();
            System.out.println(str);
           /* while( scanner.next() != null &&  !scanner.next().equals("")){
                String str = scanner.next();
                System.out.println(str);
            }*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(scanner != null){
                scanner.close();
            }
        }
    }

    public static void systemIn(){
        Scanner scanner = new Scanner(System.in);
        int temp = scanner.nextInt();
        System.out.println(temp);
        float flo=scanner.nextFloat();
        System.out.println(flo);
    }
}
