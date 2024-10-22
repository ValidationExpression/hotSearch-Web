package com.haolan.hotsearchweb.service.hotSearch.impl;

import com.haolan.hotsearchweb.mapper.HotSearchMapper;
import com.haolan.hotsearchweb.model.BiliBiliHotDO;
import com.haolan.hotsearchweb.model.DouYinHotDO;
import com.haolan.hotsearchweb.model.WeiBoHotDO;
import com.haolan.hotsearchweb.model.ZhiHuHotDO;
import com.haolan.hotsearchweb.service.hotSearch.HotSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotSearchServiceImpl implements HotSearchService {

    @Autowired
    private HotSearchMapper hotSearchMapper;

    @Override
    public List<BiliBiliHotDO> getBiliHot(String day, int timeSlot) {
        List<BiliBiliHotDO> biliBiliHotDO = new ArrayList<>();
        // 判断当前时间段
        if (timeSlot == 0) {
            // 格式化时间
            String startTime = day + " 00:00:01";
            String endTime = day + " 11:59:59";
            // 热搜列表
            biliBiliHotDO = hotSearchMapper.getBiliHot(startTime, endTime);
        }else if (timeSlot == 1) {
            String startTime = day + " 12:00:01";
            String endTime = day + " 23:59:59";
            biliBiliHotDO = hotSearchMapper.getBiliHot(startTime, endTime);
        }
        return biliBiliHotDO;
    }

    @Override
    public List<ZhiHuHotDO> getZhiHuHot(String day, int timeSlot) {
        List<ZhiHuHotDO> zhiHuHotDO = new ArrayList<>();
        // 判断当前时间段
        if (timeSlot == 0) {
            // 格式化时间
            String startTime = day + " 00:00:01";
            String endTime = day + " 11:59:59";
            // 热搜列表
            zhiHuHotDO = hotSearchMapper.getZhiHuHot(startTime, endTime);
        }else if (timeSlot == 1) {
            String startTime = day + " 12:00:01";
            String endTime = day + " 23:59:59";
            zhiHuHotDO = hotSearchMapper.getZhiHuHot(startTime, endTime);
        }
        return zhiHuHotDO;
    }

    @Override
    public List<DouYinHotDO> getDouYinHot(String day, int timeSlot) {
        List<DouYinHotDO> douYinHotDO = new ArrayList<>();
        // 判断当前时间段
        if (timeSlot == 0) {
            // 格式化时间
            String startTime = day + " 00:00:01";
            String endTime = day + " 11:59:59";
            // 热搜列表
            douYinHotDO = hotSearchMapper.getDouYinHot(startTime, endTime);
        }else if (timeSlot == 1) {
            String startTime = day + " 12:00:01";
            String endTime = day + " 23:59:59";
            douYinHotDO = hotSearchMapper.getDouYinHot(startTime, endTime);
        }
        return douYinHotDO;
    }

    @Override
    public List<WeiBoHotDO> getWeiBoHot(String day, int timeSlot) {
        List<WeiBoHotDO> weiBoHotDO = new ArrayList<>();
        // 判断当前时间段
        if (timeSlot == 0) {
            // 格式化时间
            String startTime = day + " 00:00:01";
            String endTime = day + " 11:59:59";
            // 热搜列表
            weiBoHotDO = hotSearchMapper.getWeiBoHot(startTime, endTime);
        }else if (timeSlot == 1) {
            String startTime = day + " 12:00:01";
            String endTime = day + " 23:59:59";
            weiBoHotDO = hotSearchMapper.getWeiBoHot(startTime, endTime);
        }
        return weiBoHotDO;
    }
}
