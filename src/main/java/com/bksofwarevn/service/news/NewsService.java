package com.bksofwarevn.service.news;


import com.bksofwarevn.entities.news.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NewsService {

    News findById(int id);

    Page<News> findPage(Pageable pageable);

    Page<News> findNew(Pageable pageable);

    Page<News> findHot(Pageable pageable);

    boolean save(News news);

    boolean update(News news);

    boolean delete(int id);

    Long count();
}
