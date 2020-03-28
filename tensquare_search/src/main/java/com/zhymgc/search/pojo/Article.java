package com.zhymgc.search.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * Created by Administrator on 2020-3-28.
 */
@Document(indexName = "tensquare_article", type = "article")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {
    @Id
    private String id;//ID

    /**
     * index = true 表示：
     * 1 是否索引，就是看该域是否能被搜索
     * 2 是否分词，就表示搜索时候是整体匹配还是单词匹配
     * 3 是否存储，是否在页面上显示
     */
    @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String title;//标题
    @Field
            (index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String content;//文章正文
    private String state;//审核状态
}
