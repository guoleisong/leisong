package cn.agrotechnical.service;

import cn.agrotechnical.pojo.Article;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    void updateState(String id);

    void addThumbup(String id);

    Article findById(String id);

    Page<Article> findSearch(Map searchMap, int page, int size);

    void add(Article article);

    void update(Article article);

    void deleteById(String id);

    List<Article> findAll();
}
