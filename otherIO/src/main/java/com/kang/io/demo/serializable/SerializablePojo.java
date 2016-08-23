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
public class SerializablePojo implements java.io.Serializable {
    private String name;
    private int age;
}
