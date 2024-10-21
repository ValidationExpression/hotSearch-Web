package com.haolan.hotsearchweb.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("douyin_hot_info")
public class DouYinHotDO {

    // 创建时间
    private String create_time;
    // 热搜标题
    private String title;
    // 发布时间
    private String pubdate_time;
    // 热搜值
    private Integer hot_value;

    // 热搜封面
    private String hot_search_cover;
    // 热搜排名
    private Integer hot_serch_order;
    // 热搜链接
    private String hot_url;

}
