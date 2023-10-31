package com.vincer.blogs.service.impl;

import com.vincer.blogs.domain.BlogCategory;
import com.vincer.blogs.mapper.BlogCategoryMapper;
import com.vincer.blogs.service.IBlogCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 博客分类标Service业务层处理
 *
 * @author vincer
 * @date 2023-10-31
 */
@Service
public class BlogCategoryServiceImpl implements IBlogCategoryService {
    @Resource
    private BlogCategoryMapper blogCategoryMapper;

    /**
     * 查询博客分类标
     *
     * @param id 博客分类标主键
     * @return 博客分类标
     */
    @Override
    public BlogCategory selectBlogCategoryById(Long id) {
        return blogCategoryMapper.selectBlogCategoryById(id);
    }

    /**
     * 查询博客分类标列表
     *
     * @param blogCategory 博客分类标
     * @return 博客分类标
     */
    @Override
    public List<BlogCategory> selectBlogCategoryList(BlogCategory blogCategory) {
        return blogCategoryMapper.selectBlogCategoryList(blogCategory);
    }

    /**
     * 新增博客分类标
     *
     * @param blogCategory 博客分类标
     * @return 结果
     */
    @Override
    public int insertBlogCategory(BlogCategory blogCategory) {
        return blogCategoryMapper.insertBlogCategory(blogCategory);
    }

    /**
     * 修改博客分类标
     *
     * @param blogCategory 博客分类标
     * @return 结果
     */
    @Override
    public int updateBlogCategory(BlogCategory blogCategory) {
        return blogCategoryMapper.updateBlogCategory(blogCategory);
    }

}
