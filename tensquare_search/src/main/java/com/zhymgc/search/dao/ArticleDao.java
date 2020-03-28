package com.zhymgc.search.dao;

import com.zhymgc.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by Administrator on 2020-3-28.
 */
public interface ArticleDao extends ElasticsearchRepository<Article, String> {

    /*** 检索 * @param * @return */
    public Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
