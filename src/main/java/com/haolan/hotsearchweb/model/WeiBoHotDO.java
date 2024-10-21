package com.haolan.hotsearchweb.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("weibo_hot_info")
public class WeiBoHotDO {

    // 创建时间
    private String create_time;
    // 热搜标题
    private String title;
    // 热搜值
    private String hot_value;

    // 热搜排名
    private Integer hot_serch_order;
    // 热搜链接
    private String hot_url;
}
