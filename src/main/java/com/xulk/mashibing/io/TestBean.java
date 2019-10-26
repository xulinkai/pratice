package com.xulk.mashibing.io;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by xulinkai on 2019/8/5.
 * 标记性接口  表示可以被序列化
 */
@Data
public class TestBean implements Serializable {

    String name;
    transient String id;//序列化的时候不考虑该字段
    Integer age;
}
