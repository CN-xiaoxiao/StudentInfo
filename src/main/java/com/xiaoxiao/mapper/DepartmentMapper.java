package com.xiaoxiao.mapper;

import com.xiaoxiao.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {

    List<Department> getAllDepartment();

    Department getDepartmentByName(@Param("name") String name);

    int insertDepartment(@Param("department") Department department);
}
