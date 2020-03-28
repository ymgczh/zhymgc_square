package com.zhymgc.search.service;

import com.zhymgc.search.dao.ArticleDao;
import com.zhymgc.search.pojo.Article;
import com.zhymgc.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020-3-28.
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleSearchDao;

    @Autowired
    private IdWorker idWorker;

    /*** 增加文章 * @param article */
    public void add(Article article) {
        articleSearchDao.save(article);
    }

    public Page<Article> findByTitleLike(String keywords, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page-1, size);
        return articleSearchDao.findByTitleOrContentLike(keywords, keywords, pageRequest);
    }
}
