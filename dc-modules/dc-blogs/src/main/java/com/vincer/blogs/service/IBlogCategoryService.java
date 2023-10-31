package com.vincer.blogs.service;

import com.vincer.blogs.domain.BlogCategory;

import java.util.List;

/**
 * 博客分类Service接口
 *
 * @author vincer
 * @date 2023-10-31
 */
public interface IBlogCategoryService {
    /**
     * 查询博客分类
     *
     * @param id 博客分类主键
     * @return 博客分类
     */
    BlogCategory selectBlogCategoryById(Long id);

    /**
     * 查询博客分类列表
     *
     * @param blogCategory 博客分类
     * @return 博客分类集合
     */
    List<BlogCategory> selectBlogCategoryList(BlogCategory blogCategory);

    /**
     * 新增博客分类
     *
     * @param blogCategory 博客分类
     * @return 结果
     */
    int insertBlogCategory(BlogCategory blogCategory);

    /**
     * 修改博客分类
     *
     * @param blogCategory 博客分类
     * @return 结果
     */
    int updateBlogCategory(BlogCategory blogCategory);

}
