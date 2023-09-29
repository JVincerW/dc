package com.vincer.system.service;

import java.util.List;
import com.vincer.system.domain.Article;

/**
 * 【请填写功能名称】Service接口
 *
 * @author vincer
 * @date 2023-09-29
 */
public interface IArticleService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    Article selectArticleById(String id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param article 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    List<Article> selectArticleList(Article article);

    /**
     * 新增【请填写功能名称】
     *
     * @param article 【请填写功能名称】
     * @return 结果
     */
    int insertArticle(Article article);

    /**
     * 修改【请填写功能名称】
     *
     * @param article 【请填写功能名称】
     * @return 结果
     */
    int updateArticle(Article article);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    int deleteArticleByIds(String[] ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    int deleteArticleById(String id);
}
