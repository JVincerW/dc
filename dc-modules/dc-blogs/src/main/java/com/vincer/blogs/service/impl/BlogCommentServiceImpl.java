package com.vincer.blogs.service.impl;

import com.vincer.blogs.domain.BlogComment;
import com.vincer.blogs.mapper.BlogCommentMapper;
import com.vincer.blogs.service.IBlogCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论Service业务层处理
 *
 * @author vincer
 * @date 2023-10-31
 */
@Service
public class BlogCommentServiceImpl implements IBlogCommentService {
    @Resource
    private BlogCommentMapper blogCommentMapper;

    /**
     * 查询评论
     *
     * @param id 评论主键
     * @return 评论
     */
    @Override
    public BlogComment selectBlogCommentById(Long id) {
        return blogCommentMapper.selectBlogCommentById(id);
    }

    /**
     * 查询评论列表
     *
     * @param blogComment 评论
     * @return 评论
     */
    @Override
    public List<BlogComment> selectBlogCommentList(BlogComment blogComment) {
        return blogCommentMapper.selectBlogCommentList(blogComment);
    }

    /**
     * 新增评论
     *
     * @param blogComment 评论
     * @return 结果
     */
    @Override
    public int insertBlogComment(BlogComment blogComment) {
        return blogCommentMapper.insertBlogComment(blogComment);
    }


    /**
     * 删除评论信息
     *
     * @param id 评论主键
     * @return 结果
     */
    @Override
    public int deleteBlogCommentById(Long id) {
        return blogCommentMapper.deleteBlogCommentById(id);
    }
}
