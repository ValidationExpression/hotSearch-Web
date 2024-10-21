package com.haolan.hotsearchweb.service.hotSearch;

import com.haolan.hotsearchweb.model.BiliBiliHotDO;

import java.util.List;

public interface BiliHotService {
    List<BiliBiliHotDO> getBiliHot(String day, int timeSlot);
}
