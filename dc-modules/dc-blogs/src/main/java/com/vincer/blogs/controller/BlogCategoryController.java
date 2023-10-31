package com.vincer.blogs.controller;

import com.vincer.blogs.domain.BlogCategory;
import com.vincer.blogs.service.IBlogCategoryService;
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
 * 博客分类Controller
 *
 * @author vincer
 * @date 2023-10-31
 */
@RestController
@RequestMapping("/category")
public class BlogCategoryController extends BaseController
{
    @Autowired
    private IBlogCategoryService blogCategoryService;

    /**
     * 查询博客分类列表
     */
    // @RequiresPermissions("blogs:category:list")
    @GetMapping("/list")
    public TableDataInfo list(BlogCategory blogCategory)
    {
        startPage();
        List<BlogCategory> list = blogCategoryService.selectBlogCategoryList(blogCategory);
        return getDataTable(list);
    }

    /**
     * 获取博客分类详细信息
     */
    // @RequiresPermissions("blogs:category:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(blogCategoryService.selectBlogCategoryById(id));
    }

    /**
     * 新增博客分类
     */
    @RequiresPermissions("blogs:category:add")
    @Log(title = "博客分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BlogCategory blogCategory)
    {
        return toAjax(blogCategoryService.insertBlogCategory(blogCategory));
    }

    /**
     * 修改博客分类
     */
    @RequiresPermissions("blogs:category:edit")
    @Log(title = "博客分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BlogCategory blogCategory)
    {
        return toAjax(blogCategoryService.updateBlogCategory(blogCategory));
    }

}
