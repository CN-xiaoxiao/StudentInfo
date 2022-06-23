package com.xiaoxiao.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author xiaoxiao
 */
@Data
@Accessors(chain = true)
public class Student {
    private int studentId;
    private String name;
    private String sex;
    private int studentClass;
    private int department;
    private String birthday;
    private String nativePlace;
}
