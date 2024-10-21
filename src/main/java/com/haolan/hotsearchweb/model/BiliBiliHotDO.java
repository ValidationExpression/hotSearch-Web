package com.haolan.hotsearchweb.model;

import lombok.Data;

// 这里的名称要为驼峰命名，且名称和数据库中的字段名要一致
@Data
public class BiliBiliHotDO {
    // 热搜id
    private String aid;
    // 热搜封面
    private String hotSearchCover;
    // 热搜排名
    private String hotSearchOrder;
    // 热搜发布地址
    private String ipLocal;
    // 发布时间
    private String createTime;
    // --------------------------------------
    // up主名称
    private String name;
    // up主头像
    private String face;
    // --------------------------------------
    // 热搜标题
    private String title;
    //播放数
    private Integer videoView;
    //弹幕数
    private Integer videoDanmaku;
    //评论数
    private Integer videoReply;
    //收藏数
    private Integer videoFavorite;
    //投币数
    private Integer videoCoin;
    //分享数
    private Integer videoShare;
    //点赞数
    private Integer videoLike;
    //稿件发布时间
    private String pubdateTime;
    //投稿时间
    private String ctime;
    //稿件时长
    private Double duration;
    //稿件链接
    private String videoUrl;
    //简介
    private String videoDesc;
}
