package com.xiaoxiao.entity;

import lombok.Data;

/**
 * @author xiaoxiao
 */
@Data
public class Reward {
    private int id;
    private int studentId;
    private int levels;
    private String recTime;
    private String description;
}
