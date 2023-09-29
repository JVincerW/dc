package com.vincer.system.controller;

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
import com.vincer.system.domain.Article;
import com.vincer.system.service.IArticleService;
import com.vincer.common.core.web.controller.BaseController;
import com.vincer.common.core.web.domain.AjaxResult;
import com.vincer.common.core.utils.poi.ExcelUtil;
import com.vincer.common.core.web.page.TableDataInfo;

/**
 * 博客文章Controller
 *
 * @author vincer
 * @date 2023-09-30
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController
{
    @Autowired
    private IArticleService articleService;

    /**
     * 查询博客文章列表
     */
    @RequiresPermissions("system:article:list")
    @GetMapping("/list")
    public TableDataInfo list(Article article)
    {
        startPage();
        List<Article> list = articleService.selectArticleList(article);
        return getDataTable(list);
    }

    /**
     * 导出博客文章列表
     */
    @RequiresPermissions("system:article:export")
    @Log(title = "博客文章", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Article article)
    {
        List<Article> list = articleService.selectArticleList(article);
        ExcelUtil<Article> util = new ExcelUtil<Article>(Article.class);
        util.exportExcel(response, list, "博客文章数据");
    }

    /**
     * 获取博客文章详细信息
     */
    @RequiresPermissions("system:article:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(articleService.selectArticleById(id));
    }

    /**
     * 新增博客文章
     */
    @RequiresPermissions("system:article:add")
    @Log(title = "博客文章", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Article article)
    {
        return toAjax(articleService.insertArticle(article));
    }

    /**
     * 修改博客文章
     */
    @RequiresPermissions("system:article:edit")
    @Log(title = "博客文章", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Article article)
    {
        return toAjax(articleService.updateArticle(article));
    }

    /**
     * 删除博客文章
     */
    @RequiresPermissions("system:article:remove")
    @Log(title = "博客文章", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(articleService.deleteArticleByIds(ids));
    }
}
