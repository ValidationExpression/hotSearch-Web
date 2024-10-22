package com.haolan.hotsearchweb.controller;

import com.haolan.hotsearchweb.model.*;
import com.haolan.hotsearchweb.service.hotSearch.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/hotSearch")
public class HotSearchController {


    @Autowired
    private HotSearchService hotSearchService;
    /**
     * bilibili热搜
     * @param day
     * @param timeSlot
     * @return
     */
    @GetMapping("/bilibiliHot")
    public Result<List<BiliBiliHotDO>> bilibiliHot(@Param("day") String day,@Param("timeSlot") int timeSlot){
        //bilibiliHot
        List<BiliBiliHotDO> biliBiliHotDO = hotSearchService.getBiliHot(day, timeSlot);
        return Result.success(biliBiliHotDO);
    }

    /**
     * 抖音热搜
     * @param day
     * @param timeSlot
     * @return
     */
    @GetMapping("/douyinHot")
    public Result<List<DouYinHotDO>> douyinHot(@Param("day") String day, @Param("timeSlot") int timeSlot){
        //douyinHot
        List<DouYinHotDO> douyinHotDO = hotSearchService.getDouYinHot(day, timeSlot);
        return Result.success(douyinHotDO);
    }

    /**
     * 微博热搜
     * @param day
     * @param timeSlot
     * @return
     */
    @GetMapping("/weiboHot")
    public Result<List<WeiBoHotDO>> weiboHot(@Param("day") String day, @Param("timeSlot") int timeSlot){
        //weiboHot
        List<WeiBoHotDO> weiBoHotDO = hotSearchService.getWeiBoHot(day, timeSlot);
        return Result.success(weiBoHotDO);
    }

    @GetMapping("/zhihuHot")
    public Result<List<ZhiHuHotDO>> zhihuHot(@Param("day") String day, @Param("timeSlot") int timeSlot){
        //weiboHot
        List<ZhiHuHotDO> zhiHuHotDO = hotSearchService.getZhiHuHot(day, timeSlot);
        return Result.success(zhiHuHotDO);
    }
}
