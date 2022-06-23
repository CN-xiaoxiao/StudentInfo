package com.xiaoxiao.handler;

import com.xiaoxiao.entity.Change;
import com.xiaoxiao.mapper.ChangeMapper;
import com.xiaoxiao.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author xiaoxiao
 */
public class ChangeHandler {

    public int changeRoll(int id, int changCode) {
        //
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
       ChangeMapper mapper = sqlSession.getMapper(ChangeMapper.class);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        String description = null;
        if (changCode == 0) {
            description = "转系";
        } else if (changCode == 1) {
            description = "休学";
        } else if (changCode == 2) {
            description = "复学";
        } else if (changCode == 3) {
            description = "退学";
        } else if (changCode == 4) {
            description = "毕业";
        }

        return mapper.insertChange(new Change().setChangeCode(changCode).setRecTime(formatter.format(date)).setDescription(description));
    }

    public ArrayList<Change> getAllChanges() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ChangeMapper mapper = sqlSession.getMapper(ChangeMapper.class);
        return (ArrayList<Change>) mapper.getAllChanges();
    }
}
