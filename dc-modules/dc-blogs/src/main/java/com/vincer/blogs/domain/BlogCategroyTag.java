package com.vincer.blogs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vincer.common.core.annotation.Excel;
import com.vincer.common.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 文章分类标签对象 blog_categroy_tag
 *
 * @author vincer
 * @date 2023-10-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BlogCategroyTag extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 类别id
     */
    @Excel(name = "类别id")
    private Long categoryId;

    /**
     * 标签名
     */
    @Excel(name = "标签名")
    private String name;

    /**
     * 标签说明
     */
    @Excel(name = "标签说明")
    private String desc;

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
