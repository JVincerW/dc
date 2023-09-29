package com.vincer.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vincer.common.core.annotation.Excel;
import com.vincer.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 article
 *
 * @author vincer
 * @date 2023-09-29
 */
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

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String isMarkdown;

    /** 文章内容 */
    @Excel(name = "文章内容")
    private String content;

    /** markdown版的文章内容 */
    @Excel(name = "markdown版的文章内容")
    private String contentMd;

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

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getUuid()
    {
        return uuid;
    }
    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getVersion()
    {
        return version;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setCoverImage(String coverImage)
    {
        this.coverImage = coverImage;
    }

    public String getCoverImage()
    {
        return coverImage;
    }
    public void setReadType(String readType)
    {
        this.readType = readType;
    }

    public String getReadType()
    {
        return readType;
    }
    public void setEditorType(String editorType)
    {
        this.editorType = editorType;
    }

    public String getEditorType()
    {
        return editorType;
    }
    public void setQrcodePath(String qrcodePath)
    {
        this.qrcodePath = qrcodePath;
    }

    public String getQrcodePath()
    {
        return qrcodePath;
    }
    public void setIsMarkdown(String isMarkdown)
    {
        this.isMarkdown = isMarkdown;
    }

    public String getIsMarkdown()
    {
        return isMarkdown;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setContentMd(String contentMd)
    {
        this.contentMd = contentMd;
    }

    public String getContentMd()
    {
        return contentMd;
    }
    public void setTop(Integer top)
    {
        this.top = top;
    }

    public Integer getTop()
    {
        return top;
    }
    public void setTypeId(String typeId)
    {
        this.typeId = typeId;
    }

    public String getTypeId()
    {
        return typeId;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setRecommended(String recommended)
    {
        this.recommended = recommended;
    }

    public String getRecommended()
    {
        return recommended;
    }
    public void setOriginal(String original)
    {
        this.original = original;
    }

    public String getOriginal()
    {
        return original;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setKeywords(String keywords)
    {
        this.keywords = keywords;
    }

    public String getKeywords()
    {
        return keywords;
    }
    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public String getComment()
    {
        return comment;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uuid", getUuid())
            .append("version", getVersion())
            .append("title", getTitle())
            .append("userId", getUserId())
            .append("coverImage", getCoverImage())
            .append("readType", getReadType())
            .append("editorType", getEditorType())
            .append("qrcodePath", getQrcodePath())
            .append("isMarkdown", getIsMarkdown())
            .append("content", getContent())
            .append("contentMd", getContentMd())
            .append("top", getTop())
            .append("typeId", getTypeId())
            .append("status", getStatus())
            .append("recommended", getRecommended())
            .append("original", getOriginal())
            .append("description", getDescription())
            .append("keywords", getKeywords())
            .append("comment", getComment())
            .append("password", getPassword())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
