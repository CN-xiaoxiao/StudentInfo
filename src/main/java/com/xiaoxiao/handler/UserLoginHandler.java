package com.xiaoxiao.handler;

import com.xiaoxiao.entity.User;
import com.xiaoxiao.mapper.UserMapper;
import com.xiaoxiao.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @author xiaoxiao
 */
public class UserLoginHandler{

    String login = "登录";
    String register = "注册";
    public static final int SUCCESS = 1;
    public static final int USER_NOT_FIND = 2;
    public static final int PWD_ERROR = 3;


    /**
     *
     * @param username 输入的用户名
     * @param password 输入的密码
     * @return
     */
    public int login(String username, String password) {
        // 连接数据库，查询数据，通过用户名找到该用户
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername(username);
        if (user == null) {
            return USER_NOT_FIND;
        }

        if (password.equals(user.getPassword())) {
            return SUCCESS;
        }

        return PWD_ERROR;

    }
}
