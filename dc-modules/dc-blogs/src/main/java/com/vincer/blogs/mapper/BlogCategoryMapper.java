package com.vincer.blogs.mapper;

import java.util.List;
import com.vincer.blogs.domain.BlogCategory;

/**
 * 博客分类Mapper接口
 * 
 * @author vincer
 * @date 2023-10-31
 */
public interface BlogCategoryMapper 
{
    /**
     * 查询博客分类
     * 
     * @param id 博客分类主键
     * @return 博客分类
     */
    BlogCategory selectBlogCategoryById(Long id);


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

    /**
     * 分类下面的标签列表
     *
     * @param blogCategory 分类下面的标签列表
     * @return 分类下面的标签列表
     */
    List<BlogCategory> selectBlogCategoryList(BlogCategory blogCategory);


}
