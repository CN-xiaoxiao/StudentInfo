package com.xiaoxiao.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author xiaoxiao
 */
@Data
@Accessors(chain = true)
public class Department {
    private int id;
    private String name;
}
