package com.xiaoxiao.handler;

import com.xiaoxiao.entity.Department;
import com.xiaoxiao.entity.Student;
import com.xiaoxiao.entity.StudentClass;
import com.xiaoxiao.mapper.StudentMapper;
import com.xiaoxiao.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;

/**
 * @author xiaoxiao
 */
public class StudentHandler {
    public static final int ID_IS_NULL = 0;
    public static final int NAME_IS_NULL = 2;
    public static final int SEX_IS_NULL = 3;
    public static final int BIRTHDAY_IS_NULL = 4;
    public static final int CLASS_IS_NULL = 5;
    public static final int DEPARTMENT_IS_NULL = 6;
    public static final int NATIVE_PLACE_IS_NULL = 7;
    public static final int SUCCESS = 1;



    public int addStudent(int id, String name, String sex, String birthday,
                          String studentClass, String department, String nativePlace) {

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        if ("".equals(String.valueOf(id))) {
            return ID_IS_NULL;
        }

        if ("".equals(name)) {
            return NAME_IS_NULL;
        }

        if ("".equals(sex)) {
            return SEX_IS_NULL;
        }

        if ("".equals(birthday)) {
            return BIRTHDAY_IS_NULL;
        }

        StudentClass sClass = new ClassHandler().getClassForClassName(studentClass);
        if (sClass == null) {
            return CLASS_IS_NULL;
        }

        Department depart = new DepartmentHandler().getDepartmentByName(department);
        if (depart == null) {
            return DEPARTMENT_IS_NULL;
        }

        if ("".equals(nativePlace)) {
            return NATIVE_PLACE_IS_NULL;
        }

        Student student = new Student().setStudentId(id).setName(name)
                .setSex(sex).setBirthday(birthday).setStudentClass(sClass.getId())
                .setDepartment(depart.getId()).setNativePlace(nativePlace);

        // 总感觉这里有bug
        mapper.insertStudent(new Student().setStudentId(id).setName(name)
                .setSex(sex).setBirthday(birthday).setStudentClass(sClass.getId())
                .setDepartment(depart.getId()).setNativePlace(nativePlace));

        return SUCCESS;
    }
}
