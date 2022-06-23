package com.xiaoxiao.entity;

import lombok.Data;

/**
 * @author xiaoxiao
 */
@Data
public class StudentClass {
    private int id;
    private String name;
    private int monitor;

    public StudentClass() {
    }

    public StudentClass(String name, int monitor) {
        this.name = name;
        this.monitor = monitor;
    }
}
