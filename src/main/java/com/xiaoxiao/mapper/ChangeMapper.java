package com.xiaoxiao.mapper;

import com.xiaoxiao.entity.Change;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xiaoxiao
 */
public interface ChangeMapper {
    int insertChange(@Param("roll")Change roll);
    List<Change> getAllChanges();
}
