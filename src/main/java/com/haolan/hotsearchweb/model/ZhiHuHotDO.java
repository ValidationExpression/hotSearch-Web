package com.haolan.hotsearchweb.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("zhihu_hot_info")
public class ZhiHuHotDO {

    // 主键
    private String zid;
    // 创建时间
    private String createTime;
    // 标题
    private String title;
    // 类型
    private String zhType;
    // 发布时间
    private String publishTime;
    // 内容
    private String excerpt;
    // 热搜值
    private String detailText;
    // 热搜封面
    private String hotSearchCover;
    // 热搜序号
    private Integer hotSearchOrder;
    // 热搜链接
    private String hotUrl;

}
