package com.xiaoxiao.handler;

import com.xiaoxiao.entity.Department;
import com.xiaoxiao.mapper.DepartmentMapper;
import com.xiaoxiao.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author xiaoxiao
 */
public class DepartmentHandler {

    public List<Department> getAllDepartments() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        return mapper.getAllDepartment();
    }

    public Department getDepartmentByName(String name) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        return mapper.getDepartmentByName(name);
    }

}
