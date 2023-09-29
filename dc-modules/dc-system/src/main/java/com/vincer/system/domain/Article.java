package com.vincer.system.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.vincer.common.core.annotation.Excel;
import com.vincer.common.core.web.domain.BaseEntity;

import java.util.List;

/**
 * 【文章】对象 article
 *
 * @author vincer
 * @date 2023-09-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Article extends BaseEntity
{
   private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** 版本id */
    @Excel(name = "版本id")
    private String uuid;

    /** 版本 */
    @Excel(name = "版本")
    private String version;

    /** 文章标题 */
    @Excel(name = "文章标题")
    private String title;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 文章封面图片 */
    @Excel(name = "文章封面图片")
    private String coverImage;

    /** 当前文章阅读类型 */
    @Excel(name = "当前文章阅读类型")
    private String readType;

    /** 当前文章适用的编辑器类型 */
    @Excel(name = "当前文章适用的编辑器类型")
    private String editorType;

    /** 文章专属二维码地址 */
    @Excel(name = "文章专属二维码地址")
    private String qrcodePath;

    /** 文章内容 */
    @Excel(name = "文章内容")
    private String content;

    /** 是否置顶 */
    @Excel(name = "是否置顶")
    private Integer top;

    /** 类型 */
    @Excel(name = "类型")
    private String typeId;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 是否推荐 */
    @Excel(name = "是否推荐")
    private String recommended;

    /** 是否原创 */
    @Excel(name = "是否原创")
    private String original;

    /** 文章简介，最多200字 */
    @Excel(name = "文章简介，最多200字")
    private String description;

    /** 文章关键字，优化搜索 */
    @Excel(name = "文章关键字，优化搜索")
    private String keywords;

    /** 是否开启评论 */
    @Excel(name = "是否开启评论")
    private String comment;

    /** 文章私密访问时的密钥 */
    @Excel(name = "文章私密访问时的密钥")
    private String password;

    @Excel(name = "标签")
    private List<Tag> tags;

}
