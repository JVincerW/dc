package com.vincer.system.mapper;

import java.util.List;
import com.vincer.system.domain.Article;

/**
 * 博客文章Mapper接口
 *
 * @author vincer
 * @date 2023-09-30
 */
public interface ArticleMapper
{
    /**
     * 查询博客文章
     *
     * @param id 博客文章主键
     * @return 博客文章
     */
    public Article selectArticleById(String id);

    /**
     * 查询博客文章列表
     *
     * @param article 博客文章
     * @return 博客文章集合
     */
    public List<Article> selectArticleList(Article article);

    /**
     * 新增博客文章
     *
     * @param article 博客文章
     * @return 结果
     */
    public int insertArticle(Article article);

    /**
     * 修改博客文章
     *
     * @param article 博客文章
     * @return 结果
     */
    public int updateArticle(Article article);

    /**
     * 删除博客文章
     *
     * @param id 博客文章主键
     * @return 结果
     */
    public int deleteArticleById(String id);

    /**
     * 批量删除博客文章
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteArticleByIds(String[] ids);
}