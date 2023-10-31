package com.vincer.blogs.mapper;

import com.vincer.blogs.domain.BlogComment;

import java.util.List;

/**
 * 评论Mapper接口
 *
 * @author vincer
 * @date 2023-10-31
 */
public interface BlogCommentMapper {
    /**
     * 查询评论
     *
     * @param id 评论主键
     * @return 评论
     */
    BlogComment selectBlogCommentById(Long id);

    /**
     * 查询评论列表
     *
     * @param blogComment 评论
     * @return 评论集合
     */
    List<BlogComment> selectBlogCommentList(BlogComment blogComment);

    /**
     * 新增评论
     *
     * @param blogComment 评论
     * @return 结果
     */
    int insertBlogComment(BlogComment blogComment);

    /**
     * 删除评论
     *
     * @param id 评论主键
     * @return 结果
     */
    int deleteBlogCommentById(Long id);

}
