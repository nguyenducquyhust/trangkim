package com.bksofwarevn.repository.news;

import com.bksofwarevn.entities.news.Comment;
import com.bksofwarevn.entities.news.News;
import com.bksofwarevn.entities.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {

    @Query(value = "select c from Comment c where c.news = ?1 and c.status = true order by c.id desc ")
    Page<Comment> findViaNews(News news, Pageable pageable);

    @Query(value = "select c from Comment  c where c.product = ?1 and  c.status = true order by c.id desc")
    Page<Comment> findViaProduct(Product product, Pageable pageable);

    Long countCommentByProductAndStatus(Product product, boolean status);

    Long countCommentByNewsAndStatus(News news, boolean status);
}
