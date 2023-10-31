package com.vincer.blogs.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.vincer.common.core.annotation.Excel;
import com.vincer.common.core.web.domain.BaseEntity;

/**
 * 博客标签对象 tag
 *
 * @author vincer
 * &#064;date  2023-09-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Tag extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String tag_id;

    /** 书签名 */
    @Excel(name = "书签名")
    private String tag_name;

}
