package com.vincer.blogs.domain;

import com.vincer.common.core.annotation.Excel;
import com.vincer.common.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * 博客分类标对象 blog_category
 *
 * @author vincer
 * @date 2023-10-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BlogCategory extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 分类名称
     */
    @Excel(name = "分类名称")
    private String name;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

    /**
     * 图标
     */
    @Excel(name = "图标")
    private String icon;

    /**
     * 标签
     */
    @Excel(name = "标签")
    private List<BlogCategroyTag> blogCategroyTags;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date createAt;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date updateAt;

}
