package com.vincer.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.vincer.common.core.annotation.Excel;
import com.vincer.common.core.web.domain.BaseEntity;

/**
 * 文章对象 article
 *
 * @author vincer
 * @date 2023-09-20
 */
public class Article extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 分类ID */
    @Excel(name = "分类ID")
    private Long sortId;

    /** 标签ID */
    @Excel(name = "标签ID")
    private Long labelId;

    /** 封面 */
    @Excel(name = "封面")
    private String articleCover;

    /** 博文标题 */
    @Excel(name = "博文标题")
    private String articleTitle;

    /** 博文内容 */
    @Excel(name = "博文内容")
    private String articleContent;

    /** 浏览量 */
    @Excel(name = "浏览量")
    private Long viewCount;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Long likeCount;

    /** 是否可见[0:否，1:是] */
    @Excel(name = "是否可见[0:否，1:是]")
    private Integer viewStatus;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 是否推荐[0:否，1:是] */
    @Excel(name = "是否推荐[0:否，1:是]")
    private Integer recommendStatus;

    /** 是否启用评论[0:否，1:是] */
    @Excel(name = "是否启用评论[0:否，1:是]")
    private Integer commentStatus;

    /** 是否启用[0:未删除，1:已删除] */
    @Excel(name = "是否启用[0:未删除，1:已删除]")
    private Integer deleted;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setSortId(Long sortId)
    {
        this.sortId = sortId;
    }

    public Long getSortId()
    {
        return sortId;
    }
    public void setLabelId(Long labelId)
    {
        this.labelId = labelId;
    }

    public Long getLabelId()
    {
        return labelId;
    }
    public void setArticleCover(String articleCover)
    {
        this.articleCover = articleCover;
    }

    public String getArticleCover()
    {
        return articleCover;
    }
    public void setArticleTitle(String articleTitle)
    {
        this.articleTitle = articleTitle;
    }

    public String getArticleTitle()
    {
        return articleTitle;
    }
    public void setArticleContent(String articleContent)
    {
        this.articleContent = articleContent;
    }

    public String getArticleContent()
    {
        return articleContent;
    }
    public void setViewCount(Long viewCount)
    {
        this.viewCount = viewCount;
    }

    public Long getViewCount()
    {
        return viewCount;
    }
    public void setLikeCount(Long likeCount)
    {
        this.likeCount = likeCount;
    }

    public Long getLikeCount()
    {
        return likeCount;
    }
    public void setViewStatus(Integer viewStatus)
    {
        this.viewStatus = viewStatus;
    }

    public Integer getViewStatus()
    {
        return viewStatus;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }
    public void setRecommendStatus(Integer recommendStatus)
    {
        this.recommendStatus = recommendStatus;
    }

    public Integer getRecommendStatus()
    {
        return recommendStatus;
    }
    public void setCommentStatus(Integer commentStatus)
    {
        this.commentStatus = commentStatus;
    }

    public Integer getCommentStatus()
    {
        return commentStatus;
    }
    public void setDeleted(Integer deleted)
    {
        this.deleted = deleted;
    }

    public Integer getDeleted()
    {
        return deleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("sortId", getSortId())
                .append("labelId", getLabelId())
                .append("articleCover", getArticleCover())
                .append("articleTitle", getArticleTitle())
                .append("articleContent", getArticleContent())
                .append("viewCount", getViewCount())
                .append("likeCount", getLikeCount())
                .append("viewStatus", getViewStatus())
                .append("password", getPassword())
                .append("recommendStatus", getRecommendStatus())
                .append("commentStatus", getCommentStatus())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .append("deleted", getDeleted())
                .toString();
    }
}
