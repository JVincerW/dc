package com.vincer.blogs.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vincer.common.log.annotation.Log;
import com.vincer.common.log.enums.BusinessType;
import com.vincer.common.security.annotation.RequiresPermissions;
import com.vincer.blogs.domain.BlogArticle;
import com.vincer.blogs.service.IBlogArticleService;
import com.vincer.common.core.web.controller.BaseController;
import com.vincer.common.core.web.domain.AjaxResult;
import com.vincer.common.core.utils.poi.ExcelUtil;
import com.vincer.common.core.web.page.TableDataInfo;

/**
 * 博客文章Controller
 *
 * @author vincer
 * @date 2023-10-31
 */
@RestController
@RequestMapping("/article")
public class BlogArticleController extends BaseController
{
    @Autowired
    private IBlogArticleService blogArticleService;

    /**
     * 查询博客文章列表
     */
    // @RequiresPermissions("system:article:list")
    @GetMapping("/list")
    public TableDataInfo list(BlogArticle blogArticle)
    {
        startPage();
        List<BlogArticle> list = blogArticleService.selectBlogArticleList(blogArticle);
        return getDataTable(list);
    }

    /**
     * 获取博客文章详细信息
     */
    // @RequiresPermissions("system:article:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(blogArticleService.selectBlogArticleById(id));
    }

    /**
     * 新增博客文章
     */
    @RequiresPermissions("system:article:add")
    @Log(title = "博客文章", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BlogArticle blogArticle)
    {
        return toAjax(blogArticleService.insertBlogArticle(blogArticle));
    }

    /**
     * 修改博客文章
     */
    @RequiresPermissions("system:article:edit")
    @Log(title = "博客文章", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BlogArticle blogArticle)
    {
        return toAjax(blogArticleService.updateBlogArticle(blogArticle));
    }


}