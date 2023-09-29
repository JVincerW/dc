package com.vincer.system.service.impl;

import java.util.List;
import com.vincer.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vincer.system.mapper.ArticleMapper;
import com.vincer.system.domain.Article;
import com.vincer.system.service.IArticleService;

/**
 * 【文章】Service业务层处理
 *
 * @author vincer
 * @date 2023-09-29
 */
@Service
public class ArticleServiceImpl implements IArticleService
{
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 查询【文章】
     *
     * @param id 【文章】主键
     * @return 【文章】
     */
    @Override
    public Article selectArticleById(String id)
    {
        return articleMapper.selectArticleById(id);
    }

    /**
     * 查询【文章】列表
     *
     * @param article 【文章】
     * @return 【文章】
     */
    @Override
    public List<Article> selectArticleList(Article article)
    {
        return articleMapper.selectArticleList(article);
    }

    /**
     * 新增【文章】
     *
     * @param article 【文章】
     * @return 结果
     */
    @Override
    public int insertArticle(Article article)
    {
        article.setCreateTime(DateUtils.getNowDate());
        return articleMapper.insertArticle(article);
    }

    /**
     * 修改【文章】
     *
     * @param article 【文章】
     * @return 结果
     */
    @Override
    public int updateArticle(Article article)
    {
        article.setUpdateTime(DateUtils.getNowDate());
        return articleMapper.updateArticle(article);
    }

    /**
     * 批量删除【文章】
     *
     * @param ids 需要删除的【文章】主键
     * @return 结果
     */
    @Override
    public int deleteArticleByIds(String[] ids)
    {
        return articleMapper.deleteArticleByIds(ids);
    }

    /**
     * 删除【文章】信息
     *
     * @param id 【文章】主键
     * @return 结果
     */
    @Override
    public int deleteArticleById(String id)
    {
        return articleMapper.deleteArticleById(id);
    }
}
