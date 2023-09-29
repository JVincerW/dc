package com.vincer.system.service;

import java.util.List;
import com.vincer.system.domain.Article;

/**
 * 博客文章Service接口
 *
 * @author vincer
 * @date 2023-09-30
 */
public interface IArticleService
{
    /**
     * 查询博客文章
     *
     * @param id 博客文章主键
     * @return 博客文章
     */
    Article selectArticleById(String id);

    /**
     * 查询博客文章列表
     *
     * @param article 博客文章
     * @return 博客文章集合
     */
    List<Article> selectArticleList(Article article);

    /**
     * 新增博客文章
     *
     * @param article 博客文章
     * @return 结果
     */
    int insertArticle(Article article);

    /**
     * 修改博客文章
     *
     * @param article 博客文章
     * @return 结果
     */
    int updateArticle(Article article);

    /**
     * 批量删除博客文章
     *
     * @param ids 需要删除的博客文章主键集合
     * @return 结果
     */
    int deleteArticleByIds(String[] ids);

    /**
     * 删除博客文章信息
     *
     * @param id 博客文章主键
     * @return 结果
     */
    int deleteArticleById(String id);
}
