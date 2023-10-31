package com.vincer.blogs.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.vincer.common.core.annotation.Excel;
import com.vincer.common.core.web.domain.BaseEntity;

/**
 * 博客文章对象 blog_article
 *
 * @author vincer
 * @date 2023-10-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BlogArticle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文章id */
    private Long id;

    /** 作者id */
    @Excel(name = "作者id")
    private Long userId;

    /** 封面 */
    @Excel(name = "封面")
    private String imageUrl;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 摘要 */
    @Excel(name = "摘要")
    private String excerpt;

    /** 文章内容 */
    @Excel(name = "文章内容")
    private String content;

    /** 文章状态：0.草稿、1.已发布、2.已下架、9.已删除 */
    @Excel(name = "文章状态：0.草稿、1.已发布、2.已下架、9.已删除")
    private Long status;

    /** 是否启用评论 0.否 1.是 */
    @Excel(name = "是否启用评论 0.否 1.是")
    private Long allowComment;

    /** 点赞次数 */
    @Excel(name = "点赞次数")
    private Long likes;

    /** 阅读次数 */
    @Excel(name = "阅读次数")
    private Long views;

    /** 是否开启赞赏 0.否 1.是 */
    @Excel(name = "是否开启赞赏 0.否 1.是")
    private Long appreciation;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createAt;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateAt;

}