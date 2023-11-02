package com.vincer.blogs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vincer.common.core.annotation.Excel;
import com.vincer.common.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 评论对象 blog_comment
 *
 * @author vincer
 * @date 2023-10-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BlogComment extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    private Long id;

    /**
     * 评论人ID
     */
    @Excel(name = "评论人ID")
    private Long userId;

    /**
     * 文章id
     */
    @Excel(name = "文章id")
    private Long articleId;

    /**
     * 内容
     */
    @Excel(name = "内容")
    private String content;

    /**
     * 回复人id
     */
    @Excel(name = "回复人id")
    private Long replyUserId;

    /**
     * 父id
     */
    @Excel(name = "父id")
    private Long parentId;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String browser;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String browserVersion;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String system;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String systemVersion;

    /**
     * ip地址
     */
    @Excel(name = "ip地址")
    private String ipAddress;

    /**
     * 评论时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "评论时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createAt;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateAt;

}
