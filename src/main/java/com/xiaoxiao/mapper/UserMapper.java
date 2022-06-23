package com.xiaoxiao.mapper;

import com.xiaoxiao.entity.Student;
import com.xiaoxiao.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xiaoxiao
 */
public interface UserMapper {

    User getUserByUsername(@Param("username") String username);
    List<Student> getAllUsers();
    int insertUser(@Param("user") User user);
}
