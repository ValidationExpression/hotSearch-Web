package com.haolan.hotsearchweb.service.hotSearch;

import com.haolan.hotsearchweb.model.BiliBiliHotDO;
import com.haolan.hotsearchweb.model.DouYinHotDO;
import com.haolan.hotsearchweb.model.WeiBoHotDO;
import com.haolan.hotsearchweb.model.ZhiHuHotDO;

import java.util.List;

public interface HotSearchService {

    List<BiliBiliHotDO> getBiliHot(String day, int timeSlot);

    List<ZhiHuHotDO> getZhiHuHot(String day, int timeSlot);

    List<DouYinHotDO> getDouYinHot(String day, int timeSlot);

    List<WeiBoHotDO> getWeiBoHot(String day, int timeSlot);

}
