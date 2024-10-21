package com.haolan.hotsearchweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haolan.hotsearchweb.model.BiliBiliHotDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BiliHotMapper extends BaseMapper<BiliBiliHotDO> {

    // 获取bili热搜数据
    List<BiliBiliHotDO> getBiliHot(@Param("startTime") String startTime, @Param("endTime") String endTime);
}
