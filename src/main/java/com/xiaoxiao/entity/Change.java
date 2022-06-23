package com.xiaoxiao.entity;

import lombok.Data;

/**
 * @author xiaoxiao
 */
@Data
public class Change {
    private int id;
    private int studentId;
    private int change;
    private String recTime;
    private String description;
}
