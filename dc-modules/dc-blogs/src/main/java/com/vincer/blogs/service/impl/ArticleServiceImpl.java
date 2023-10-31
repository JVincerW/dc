package com.vincer.blogs.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vincer.blogs.mapper.ArticleMapper;
import com.vincer.blogs.domain.Article;
import com.vincer.blogs.service.IArticleService;

/**
 * 博客文章Service业务层处理
 *
 * @author vincer
 * @date 2023-09-30
 */
@Service
public class ArticleServiceImpl implements IArticleService
{
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 查询博客文章
     *
     * @param id 博客文章主键
     * @return 博客文章
     */
    @Override
    public Article selectArticleById(String id)
    {
        return articleMapper.selectArticleById(id);
    }

    /**
     * 查询博客文章列表
     *
     * @param article 博客文章
     * @return 博客文章
     */
    @Override
    public List<Article> selectArticleList(Article article)
    {
        return articleMapper.selectArticleList(article);
    }

    /**
     * 新增博客文章
     *
     * @param article 博客文章
     * @return 结果
     */
    @Override
    public int insertArticle(Article article)
    {
        return articleMapper.insertArticle(article);
    }

    /**
     * 修改博客文章
     *
     * @param article 博客文章
     * @return 结果
     */
    @Override
    public int updateArticle(Article article)
    {
        return articleMapper.updateArticle(article);
    }

    /**
     * 批量删除博客文章
     *
     * @param ids 需要删除的博客文章主键
     * @return 结果
     */
    @Override
    public int deleteArticleByIds(String[] ids)
    {
        return articleMapper.deleteArticleByIds(ids);
    }

    /**
     * 删除博客文章信息
     *
     * @param id 博客文章主键
     * @return 结果
     */
    @Override
    public int deleteArticleById(String id)
    {
        return articleMapper.deleteArticleById(id);
    }
}
