package com.xiaoxiao.entity;

import lombok.Data;

/**
 * @author xiaoxiao
 */
@Data
public class Punishment {
    private int id;
    private int studentId;
    private int levels;
    private String recTime;
    private String enable;
    private String description;
}
