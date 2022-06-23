package com.xiaoxiao.mapper;

import com.xiaoxiao.entity.Reward;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * @author xiaoxiao
 */
public interface RewardMapper {

    String getDescriptionById(@Param("id") int id);

    int getCodeByDescription(@Param("description") String description);

    int insertReward(@Param("reward") Reward reward);
}
