package com.vincer.blogs.service.impl;

import com.vincer.blogs.domain.BlogCategroyTag;
import com.vincer.blogs.mapper.BlogCategroyTagMapper;
import com.vincer.blogs.service.IBlogCategroyTagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章分类标签Service业务层处理
 *
 * @author vincer
 * @date 2023-10-31
 */
@Service
public class BlogCategroyTagServiceImpl implements IBlogCategroyTagService {
    @Resource
    private BlogCategroyTagMapper blogCategroyTagMapper;

    /**
     * 查询文章分类标签
     *
     * @param id 文章分类标签主键
     * @return 文章分类标签
     */
    @Override
    public BlogCategroyTag selectBlogCategroyTagById(Long id) {
        return blogCategroyTagMapper.selectBlogCategroyTagById(id);
    }

    /**
     * 查询文章分类标签列表
     *
     * @param blogCategroyTag 文章分类标签
     * @return 文章分类标签
     */
    @Override
    public List<BlogCategroyTag> selectBlogCategroyTagList(BlogCategroyTag blogCategroyTag) {
        return blogCategroyTagMapper.selectBlogCategroyTagList(blogCategroyTag);
    }

    /**
     * 新增文章分类标签
     *
     * @param blogCategroyTag 文章分类标签
     * @return 结果
     */
    @Override
    public int insertBlogCategroyTag(BlogCategroyTag blogCategroyTag) {
        return blogCategroyTagMapper.insertBlogCategroyTag(blogCategroyTag);
    }

    /**
     * 修改文章分类标签
     *
     * @param blogCategroyTag 文章分类标签
     * @return 结果
     */
    @Override
    public int updateBlogCategroyTag(BlogCategroyTag blogCategroyTag) {
        return blogCategroyTagMapper.updateBlogCategroyTag(blogCategroyTag);
    }
}
