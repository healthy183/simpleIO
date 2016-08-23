package com.kang.io.demo.serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/8/2.
 * @Author Healthy
 * @Version
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Person implements java.io.Serializable {
    private transient String name; //transient声明该字段会不被序列/反序列化
    private int age;
}
