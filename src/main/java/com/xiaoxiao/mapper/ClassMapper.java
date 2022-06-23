package com.xiaoxiao.mapper;

import com.xiaoxiao.entity.StudentClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xiaoxiao
 */
public interface ClassMapper {

    int insertClass(@Param("studentClass") StudentClass studentClass);

    StudentClass selectClass(@Param("name") String name);

    List<StudentClass> getAllClass();
}
