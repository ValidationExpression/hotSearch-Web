package com.haolan.hotsearchweb.service.hotSearch;

import com.haolan.hotsearchweb.mapper.BiliHotMapper;
import com.haolan.hotsearchweb.model.BiliBiliHotDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BiliHotServicelmpl implements BiliHotService {

    @Autowired
    private BiliHotMapper biliHotMapper;
    @Override
    public List<BiliBiliHotDO> getBiliHot(String day, int timeSlot) {
        List<BiliBiliHotDO> biliBiliHotDO = new ArrayList<>();
        // 判断当前时间段
        if (timeSlot == 0) {
            // 格式化时间
            String startTime = day + " 00:00:01";
            String endTime = day + " 11:59:59";
            System.out.println("格式化后时间start："+startTime +",end:"+ endTime);
            // 热搜列表
            biliBiliHotDO = biliHotMapper.getBiliHot(startTime, endTime);
        }else if (timeSlot == 1) {
            String startTime = day + " 12:00:01";
            String endTime = day + " 23:59:59";
            System.out.println("格式化后时间start："+startTime +",end:"+ endTime);
            biliBiliHotDO = biliHotMapper.getBiliHot(startTime, endTime);
        }
        System.out.println("biliBiliHotDO:"+biliBiliHotDO);
        return biliBiliHotDO;
    }
}
