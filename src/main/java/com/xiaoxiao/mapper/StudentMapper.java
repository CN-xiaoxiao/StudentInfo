package com.xiaoxiao.mapper;

import com.xiaoxiao.entity.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    Student selectStudentById(Integer id);

    int insertStudent(@Param("student") Student student);

    int updateStudent(@Param("student") Student student);
}
