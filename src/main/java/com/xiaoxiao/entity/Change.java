package com.xiaoxiao.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author xiaoxiao
 */
@Data
@Accessors(chain = true)
public class Change {
    private int id;
    private int studentId;
    private int changeCode;
    private String recTime;
    private String description;
}
