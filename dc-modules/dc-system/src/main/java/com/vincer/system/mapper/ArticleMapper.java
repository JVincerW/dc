package com.vincer.system.mapper;

import java.util.List;
import com.vincer.system.domain.Article;

/**
 * 【文章】Mapper接口
 *
 * @author vincer
 * @date 2023-09-29
 */
public interface ArticleMapper
{
    /**
     * 查询【文章】
     *
     * @param id 【文章】主键
     * @return 【文章】
     */
    Article selectArticleById(String id);

    /**
     * 查询【文章】列表
     *
     * @param article 【文章】
     * @return 【文章】集合
     */
    List<Article> selectArticleList(Article article);

    /**
     * 新增【文章】
     *
     * @param article 【文章】
     * @return 结果
     */
    int insertArticle(Article article);

    /**
     * 修改【文章】
     *
     * @param article 【文章】
     * @return 结果
     */
    int updateArticle(Article article);

    /**
     * 删除【文章】
     *
     * @param id 【文章】主键
     * @return 结果
     */
    int deleteArticleById(String id);

    /**
     * 批量删除【文章】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteArticleByIds(String[] ids);
}
