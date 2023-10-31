package com.vincer.blogs.mapper;

import com.vincer.blogs.domain.Article;

import java.util.List;

/**
 * 博客文章Mapper接口
 *
 * @author vincer
 * @date 2023-09-30
 */
public interface ArticleMapper {
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
     * 删除博客文章
     *
     * @param id 博客文章主键
     * @return 结果
     */
    int deleteArticleById(String id);

    /**
     * 批量删除博客文章
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteArticleByIds(String[] ids);
}