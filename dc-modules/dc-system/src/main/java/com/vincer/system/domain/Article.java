package com.vincer.system.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.vincer.common.core.annotation.Excel;
import com.vincer.common.core.web.domain.BaseEntity;

/**
 * 博客文章对象 article
 *
 * @author vincer
 * @date 2023-09-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Article extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文档id */
    @Excel(name = "文档id")
    private String id;

    /** 博客id */
    private String uuid;

    /** 版本号 */
    private String version;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 文章内容 */
    private String content;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Long pollCount;

    /** 封面图 */
    @Excel(name = "封面图")
    private String coverImage;

    /** 评论数 */
    @Excel(name = "评论数")
    private Long commentCount;

    /** 阅读类型 */
    @Excel(name = "阅读类型")
    private String readType;

    /** 编辑类型 */
    @Excel(name = "编辑类型")
    private String editorType;

    /** 二维码 */
    private String qrcodePath;

    /** 是否置顶 */
    @Excel(name = "是否置顶")
    private Boolean top;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 是否推荐 */
    @Excel(name = "是否推荐")
    private Boolean recommended;

    /** 原创类型 */
    private Boolean original;

    /** 文章简介 */
    private String description;

    /** 关键字 */
    private String keywords;

    /** 是否开启评论 */
    @Excel(name = "是否开启评论")
    private Boolean comment;

    /** 文章私密访问时的密钥 */
    private String password;

    /** 添加时间 */
    private Date createAt;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateAt;


    @Excel(name = "标签")
    private List<Tag> tags;
}
