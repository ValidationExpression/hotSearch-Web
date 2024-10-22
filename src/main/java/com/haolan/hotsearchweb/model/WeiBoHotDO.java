package com.haolan.hotsearchweb.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("weibo_hot_info")
public class WeiBoHotDO {

    // 创建时间
    private String createTime;
    // 热搜标题
    private String title;
    // 热搜值
    private String hotValue;

    // 热搜排名
    private Integer hotSearchOrder;
    // 热搜链接
    private String hotUrl;
}
