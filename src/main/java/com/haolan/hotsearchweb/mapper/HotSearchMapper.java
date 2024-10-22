package com.haolan.hotsearchweb.mapper;

import com.haolan.hotsearchweb.model.BiliBiliHotDO;
import com.haolan.hotsearchweb.model.DouYinHotDO;
import com.haolan.hotsearchweb.model.WeiBoHotDO;
import com.haolan.hotsearchweb.model.ZhiHuHotDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HotSearchMapper {
    List<BiliBiliHotDO> getBiliHot(@Param("startTime") String startTime, @Param("endTime") String endTime);

    List<DouYinHotDO> getDouYinHot(@Param("startTime") String startTime,@Param("endTime") String endTime);

    List<ZhiHuHotDO> getZhiHuHot(@Param("startTime")String startTime,@Param("endTime") String endTime);

    List<WeiBoHotDO> getWeiBoHot(@Param("startTime") String startTime,@Param("endTime") String endTime);
}
