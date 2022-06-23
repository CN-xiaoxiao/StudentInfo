package com.xiaoxiao.mapper;

import com.xiaoxiao.entity.Punishment;
import org.apache.ibatis.annotations.Param;

public interface PunishmentMapper {
    String getDescriptionByCode(@Param("code") int code);

    int getCodeByDescription(@Param("description") String description);

    int insertPunishment(@Param("punishment") Punishment punishment);
}
