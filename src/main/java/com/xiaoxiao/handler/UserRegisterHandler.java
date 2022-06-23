package com.xiaoxiao.handler;

import com.xiaoxiao.entity.User;
import com.xiaoxiao.mapper.UserMapper;
import com.xiaoxiao.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @author xiaoxiao
 */
public class UserRegisterHandler {
    public static final int SUCCESS = 1;
    public static final int USER_REGISTERED = 2;
    public static final int PSD_DIFFERENT = 3;
    public static final int USERNAME_NONE = 4;
    public static final int PASSWORD_NONE = 5;

    public int registerUser(String username, String password1, String password2) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername(username);
        if ("".equals(username)) {
            return USERNAME_NONE;
        }
        // 用户不为空，说明已经被注册
        if (user != null) {
            return USER_REGISTERED;
        }

        if ("".equals(password1)) {
            return PASSWORD_NONE;
        }

        if (!password1.equals(password2)) {
            return PSD_DIFFERENT;
        }

        mapper.insertUser(new User(username, password1));
        return SUCCESS;
    }
}
