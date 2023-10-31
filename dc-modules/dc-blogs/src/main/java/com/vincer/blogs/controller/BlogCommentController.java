package com.vincer.blogs.controller;

import com.vincer.blogs.domain.BlogComment;
import com.vincer.blogs.service.IBlogCommentService;
import com.vincer.common.core.web.controller.BaseController;
import com.vincer.common.core.web.domain.AjaxResult;
import com.vincer.common.core.web.page.TableDataInfo;
import com.vincer.common.log.annotation.Log;
import com.vincer.common.log.enums.BusinessType;
import com.vincer.common.security.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 评论Controller
 *
 * @author vincer
 * @date 2023-10-31
 */
@RestController
@RequestMapping("/comment")
public class BlogCommentController extends BaseController {
    @Autowired
    private IBlogCommentService blogCommentService;

    /**
     * 查询评论列表
     */
    // @RequiresPermissions("blogs:comment:list")
    @GetMapping("/list")
    public TableDataInfo list(BlogComment blogComment) {
        startPage();
        List<BlogComment> list = blogCommentService.selectBlogCommentList(blogComment);
        return getDataTable(list);
    }


    /**
     * 获取评论详细信息
     */
    // @RequiresPermissions("blogs:comment:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(blogCommentService.selectBlogCommentById(id));
    }

    /**
     * 新增评论
     */
    @RequiresPermissions("blogs:comment:add")
    @Log(title = "评论", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BlogComment blogComment) {
        return toAjax(blogCommentService.insertBlogComment(blogComment));
    }

    /**
     * 删除评论
     */
    @RequiresPermissions("blogs:comment:remove")
    @Log(title = "评论", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable Long id) {
        return toAjax(blogCommentService.deleteBlogCommentById(id));
    }
}
