package com.xiaoxiao.handler;

import com.xiaoxiao.entity.Punishment;
import com.xiaoxiao.mapper.PunishmentMapper;
import com.xiaoxiao.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @author xiaoxiao
 */
public class PunishmentHandler {
    public String getDescriptionByCode(int code) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        PunishmentMapper mapper = sqlSession.getMapper(PunishmentMapper.class);

        return mapper.getDescriptionByCode(code);
    }

    public int getCodeByDescription(String description) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        PunishmentMapper mapper = sqlSession.getMapper(PunishmentMapper.class);

        return mapper.getCodeByDescription(description);
    }

    public int addPunish(Punishment punishment) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        PunishmentMapper mapper = sqlSession.getMapper(PunishmentMapper.class);

        return mapper.insertPunishment(punishment);
    }
}
