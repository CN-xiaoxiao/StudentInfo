package com.xiaoxiao.handler;

import com.xiaoxiao.entity.Reward;
import com.xiaoxiao.mapper.RewardMapper;
import com.xiaoxiao.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @author xiaoxiao
 */
public class RewardHandler {
    public String getDescriptionByCode(int id) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        RewardMapper mapper = sqlSession.getMapper(RewardMapper.class);

        return mapper.getDescriptionById(id);
    }

    public int addReward(Reward reward) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        RewardMapper mapper = sqlSession.getMapper(RewardMapper.class);

        return mapper.insertReward(reward);
    }

    public int getCodeByDescription(String description) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        RewardMapper mapper = sqlSession.getMapper(RewardMapper.class);

        return  mapper.getCodeByDescription(description);
    }

}
