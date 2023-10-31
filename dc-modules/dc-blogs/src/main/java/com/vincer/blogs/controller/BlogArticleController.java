package com.vincer.blogs.controller;

import com.vincer.blogs.domain.BlogArticle;
import com.vincer.blogs.service.IBlogArticleService;
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
 * 博客文章Controller
 *
 * @author vincer
 * @date 2023-10-31
 */
@RestController
@RequestMapping("/article")
public class BlogArticleController extends BaseController {
    @Autowired
    private IBlogArticleService blogArticleService;

    /**
     * 查询博客文章列表
     */
    // @RequiresPermissions("system:article:list")
    @GetMapping("/list")
    public TableDataInfo list(BlogArticle blogArticle) {
        startPage();
        List<BlogArticle> list = blogArticleService.selectBlogArticleList(blogArticle);
        return getDataTable(list);
    }

    /**
     * 获取博客文章详细信息
     */
    // @RequiresPermissions("system:article:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(blogArticleService.selectBlogArticleById(id));
    }

    /**
     * 新增博客文章
     */
    @RequiresPermissions("system:article:add")
    @Log(title = "博客文章", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BlogArticle blogArticle) {
        return toAjax(blogArticleService.insertBlogArticle(blogArticle));
    }

    /**
     * 修改博客文章
     */
    @RequiresPermissions("system:article:edit")
    @Log(title = "博客文章", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BlogArticle blogArticle) {
        return toAjax(blogArticleService.updateBlogArticle(blogArticle));
    }


}