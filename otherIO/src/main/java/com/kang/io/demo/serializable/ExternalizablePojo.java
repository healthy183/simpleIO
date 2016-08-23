package com.kang.io.demo.serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.*;

/**
 * @Title 类名
 * @Description 自定义序列化/反序列化
 * @Date 2016/8/2.
 * @Author Healthy
 * @Version
 */
public class ExternalizablePojo {

    public static void main(String[] args) throws Exception {
        ser();
        dser();
    }

    public static void ser()throws Exception{
        File file = new File("d:" + File.separator + "javaio/hello.txt");
        ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(new Tom("rollen", 20));
        out.close();
    }

    public static void dser()throws Exception{
        File file = new File("d:" + File.separator + "javaio/hello.txt");
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
        Object obj =input.readObject();
        input.close();
        System.out.println(obj);
    }


    }

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
class Tom implements Externalizable {

    private String name;
    private int age;

    // 复写这个方法，根据需要可以保存的属性或者具体内容，在序列化的时候使用
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.name);
        out.writeInt(age);
    }

    //复写这个方法，根据需要读取内容 反序列话的时候需要
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = (String)in.readObject();
        this.age =in.readInt();
    }
}
