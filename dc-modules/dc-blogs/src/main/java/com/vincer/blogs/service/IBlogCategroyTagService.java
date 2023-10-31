package com.vincer.blogs.service;

import com.vincer.blogs.domain.BlogCategroyTag;

import java.util.List;

/**
 * 文章分类标签Service接口
 *
 * @author vincer
 * @date 2023-10-31
 */
public interface IBlogCategroyTagService {
    /**
     * 查询文章分类标签
     *
     * @param id 文章分类标签主键
     * @return 文章分类标签
     */
    BlogCategroyTag selectBlogCategroyTagById(Long id);

    /**
     * 查询文章分类标签列表
     *
     * @param blogCategroyTag 文章分类标签
     * @return 文章分类标签集合
     */
    List<BlogCategroyTag> selectBlogCategroyTagList(BlogCategroyTag blogCategroyTag);

    /**
     * 新增文章分类标签
     *
     * @param blogCategroyTag 文章分类标签
     * @return 结果
     */
    int insertBlogCategroyTag(BlogCategroyTag blogCategroyTag);

    /**
     * 修改文章分类标签
     *
     * @param blogCategroyTag 文章分类标签
     * @return 结果
     */
    int updateBlogCategroyTag(BlogCategroyTag blogCategroyTag);

}
