package com.xiaoxiao.handler;

import com.xiaoxiao.entity.StudentClass;
import com.xiaoxiao.mapper.ClassMapper;
import com.xiaoxiao.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author xiaoxiao
 *
 */
public class ClassHandler {

    public static final int CLASS_EXISTENCE = 0;
    public static final int SUCCESS = 1;
    public static final int CLASS_NAME_NONE = 2;
    public static final int MONITOR_IS_NONE = 3;
    public static final int ERROR = 4;

    public int addClass(String name, String monitor) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        StudentClass studentClass = mapper.selectClass(name);

        // 是否存在此班级
        if (studentClass != null) {
            return CLASS_EXISTENCE;
        }

        if ("".equals(name)) {
            return CLASS_NAME_NONE;
        }

        if ("".equals(monitor)) {
            return MONITOR_IS_NONE;
        }

        int flag = 666;
        try {
            flag = mapper.insertClass(new StudentClass(name, Integer.parseInt(monitor)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(flag);
        if (flag == 1) {
            return SUCCESS;
        }

        return ERROR;
    }

    public List<StudentClass> getAllClass() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);

        return mapper.getAllClass();
    }

    public StudentClass getClassForClassName(String className) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);

        return mapper.selectClass(className);
    }
}
