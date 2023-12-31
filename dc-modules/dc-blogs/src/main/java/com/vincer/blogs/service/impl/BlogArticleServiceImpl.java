package com.vincer.blogs.service.impl;

import com.vincer.blogs.domain.BlogArticle;
import com.vincer.blogs.mapper.BlogArticleMapper;
import com.vincer.blogs.service.IBlogArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 博客文章Service业务层处理
 * @author vincer
 * @date 2023-10-31
 */
@Service
public class BlogArticleServiceImpl implements IBlogArticleService {
    @Resource
    private BlogArticleMapper blogArticleMapper;

    /**
     * 查询博客文章
     * @param id 博客文章主键
     * @return 博客文章
     */
    @Override
    public BlogArticle selectBlogArticleById(Long id) {
        return blogArticleMapper.selectBlogArticleById(id);
    }

    /**
     * 查询博客文章列表
     *
     * @param blogArticle 博客文章
     * @return 博客文章
     */
    @Override
    public List<BlogArticle> selectBlogArticleList(BlogArticle blogArticle) {
        return blogArticleMapper.selectBlogArticleList(blogArticle);
    }

    /**
     * 新增博客文章
     *
     * @param blogArticle 博客文章
     * @return 结果
     */
    @Override
    public int insertBlogArticle(BlogArticle blogArticle) {
        return blogArticleMapper.insertBlogArticle(blogArticle);
    }

    /**
     * 修改博客文章
     *
     * @param blogArticle 博客文章
     * @return 结果
     */
    @Override
    public int updateBlogArticle(BlogArticle blogArticle) {
        // 获取博客的用户
        return blogArticleMapper.updateBlogArticle(blogArticle);
    }
}