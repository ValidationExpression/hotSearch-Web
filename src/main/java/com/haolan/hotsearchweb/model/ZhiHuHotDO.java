package com.haolan.hotsearchweb.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("zhihu_hot_info")
public class ZhiHuHotDO {
    // 创建时间
    private String create_time;
    // 标题
    private String title;
    // 类型
    private String zh_type;
    // 发布时间
    private String publish_time;
    // 内容
    private String excerpt;
    // 热搜值
    private String detail_text;
    // 热搜封面
    private String hot_search_cover;
    // 热搜序号
    private Integer hot_search_order;
    // 热搜链接
    private String hot_url;

}
