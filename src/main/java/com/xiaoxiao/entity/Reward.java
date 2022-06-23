package com.xiaoxiao.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author xiaoxiao
 */
@Data
@Accessors(chain = true)
public class Reward {
    private int id;
    private int studentId;
    private int levels;
    private String recTime;
    private String description;
}
