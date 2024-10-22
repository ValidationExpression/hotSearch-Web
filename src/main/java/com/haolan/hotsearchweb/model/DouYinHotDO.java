package com.haolan.hotsearchweb.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("douyin_hot_info")
public class DouYinHotDO {

    // 热搜id
    private String groupId;
    // 创建时间
    private String createTime;
    // 热搜标题
    private String title;
    // 发布时间
    private String publishTime;
    // 热搜值
    private Integer hotValue;

    // 热搜封面
    private String hotSearchCover;
    // 热搜排名
    private Integer hotSearchOrder;
    // 热搜链接
    private String hotUrl;

}
