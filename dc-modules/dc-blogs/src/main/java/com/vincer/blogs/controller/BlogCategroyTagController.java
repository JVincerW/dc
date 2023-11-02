package com.vincer.blogs.controller;

import com.vincer.blogs.domain.BlogCategroyTag;
import com.vincer.blogs.service.IBlogCategroyTagService;
import com.vincer.common.core.web.controller.BaseController;
import com.vincer.common.core.web.domain.AjaxResult;
import com.vincer.common.core.web.page.TableDataInfo;
import com.vincer.common.log.annotation.Log;
import com.vincer.common.log.enums.BusinessType;
import com.vincer.common.security.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章分类标签Controller
 *
 * @author vincer
 * @date 2023-10-31
 */
@RestController
@RequestMapping("/tag")
public class BlogCategroyTagController extends BaseController {
    @Resource
    private IBlogCategroyTagService blogCategroyTagService;

    /**
     * 查询文章分类标签列表
     */
    // @RequiresPermissions("blogs:tag:list")
    @GetMapping("/list")
    public TableDataInfo list(BlogCategroyTag blogCategroyTag) {
        startPage();
        List<BlogCategroyTag> list = blogCategroyTagService.selectBlogCategroyTagList(blogCategroyTag);
        return getDataTable(list);
    }

    /**
     * 获取文章分类标签详细信息
     */
    // @RequiresPermissions("blogs:tag:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(blogCategroyTagService.selectBlogCategroyTagById(id));
    }

    /**
     * 新增文章分类标签
     */
    @RequiresPermissions("blogs:tag:add")
    @Log(title = "文章分类标签", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BlogCategroyTag blogCategroyTag) {
        return toAjax(blogCategroyTagService.insertBlogCategroyTag(blogCategroyTag));
    }

    /**
     * 修改文章分类标签
     */
    @RequiresPermissions("blogs:tag:edit")
    @Log(title = "文章分类标签", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BlogCategroyTag blogCategroyTag) {
        return toAjax(blogCategroyTagService.updateBlogCategroyTag(blogCategroyTag));
    }

}
