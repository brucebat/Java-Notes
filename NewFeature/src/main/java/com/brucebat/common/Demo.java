package com.brucebat.common;

import java.io.Serializable;

/**
 * 测试类
 *
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2025/1/30 18:42
 */
public class Demo implements Serializable {

    private String name;
    private transient int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
