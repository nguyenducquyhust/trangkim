package com.bksofwarevn.service.news;


import com.bksofwarevn.entities.news.Comment;
import com.bksofwarevn.entities.news.News;
import com.bksofwarevn.entities.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {

    Page<Comment> findViaNews(News news, Pageable pageable);

    Page<Comment> findViaProduct(Product product, Pageable pageable);

    boolean save(Comment comment);

    Long countByNews(News news);

    Long countByProduct(Product product);
}
