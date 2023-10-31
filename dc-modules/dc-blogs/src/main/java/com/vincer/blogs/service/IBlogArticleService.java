package com.vincer.blogs.service;

import java.util.List;
import com.vincer.blogs.domain.BlogArticle;

/**
 * 博客文章Service接口
 *
 * @author vincer
 * @date 2023-10-31
 */
public interface IBlogArticleService
{
    /**
     * 查询博客文章
     *
     * @param id 博客文章主键
     * @return 博客文章
     */
     BlogArticle selectBlogArticleById(Long id);

    /**
     * 查询博客文章列表
     *
     * @param blogArticle 博客文章
     * @return 博客文章集合
     */
     List<BlogArticle> selectBlogArticleList(BlogArticle blogArticle);

    /**
     * 新增博客文章
     *
     * @param blogArticle 博客文章
     * @return 结果
     */
     int insertBlogArticle(BlogArticle blogArticle);

    /**
     * 修改博客文章
     *
     * @param blogArticle 博客文章
     * @return 结果
     */
     int updateBlogArticle(BlogArticle blogArticle);

}