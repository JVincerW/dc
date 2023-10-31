package com.vincer.blogs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vincer.common.core.annotation.Excel;
import com.vincer.common.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 博客文章对象 blog_article
 *
 * @author vincer
 * @date 2023-10-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BlogArticle extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 文章id
     */
    private Long id;

    /**
     * 作者id
     */
    @Excel(name = "作者id")
    private Long userId;

    /**
     * 封面
     */
    @Excel(name = "封面")
    private String imageUrl;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String title;

    /**
     * 摘要
     */
    @Excel(name = "摘要")
    private String excerpt;

    /**
     * 文章内容
     */
    @Excel(name = "内容类型")
    private Long contentType;

    /**
     * 文章内容
     */
    @Excel(name = "文章内容")
    private String content;

    /**
     * 文章状态：0.草稿、1.已发布、2.已下架、9.已删除
     */
    @Excel(name = "文章状态：0.草稿、1.已发布、2.已下架、9.已删除")
    private Long status;

    /**
     * 阅读类型：0.无需验证 1.密码验证 2.仅自己
     */
    @Excel(name = "阅读类型：0.无需验证 1.密码验证 2.仅自己")
    private Long readType;

    /**
     * 是否启用评论 0.否 1.是
     */
    @Excel(name = "是否启用评论 0.否 1.是")
    private Boolean allowComment;

    /**
     * 点赞次数
     */
    @Excel(name = "点赞次数")
    private Long likes;

    /**
     * 阅读次数
     */
    @Excel(name = "阅读次数")
    private Long views;

    /**
     * 是否开启赞赏 0.否 1.是
     */
    @Excel(name = "是否开启赞赏 0.否 1.是")
    private Boolean appreciation;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createAt;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateAt;

}