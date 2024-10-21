package com.haolan.hotsearchweb.controller;

import com.haolan.hotsearchweb.model.BiliBiliHotDO;
import com.haolan.hotsearchweb.model.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haolan.hotsearchweb.service.hotSearch.BiliHotService;

import java.util.List;


@RestController
@RequestMapping("/hotSearch")
public class HotSearchController {

    @Autowired
    private BiliHotService biliHotService;

    @GetMapping("/bilibiliHot")
    public Result<List<BiliBiliHotDO>> bilibiliHot(@Param("day") String day,@Param("timeSlot") int timeSlot){
        //bilibiliHot
        List<BiliBiliHotDO> biliBiliHotDO = biliHotService.getBiliHot(day, timeSlot);
        return Result.success(biliBiliHotDO);
    }


}
