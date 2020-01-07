package com.bksofwarevn.repository.news;


import com.bksofwarevn.entities.news.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepo extends JpaRepository<News, Integer> {

    News findById(int id);

    @Query("select n from  News  n where  n.status = true")
    Page<News> findPage(Pageable pageable);

    @Query(value = "select n from News n where n.status = true order by n.date DESC ")
    Page<News> findNew(Pageable pageable);

    @Query(value = "select n from News n where n.status = true order by n.likes DESC ")
    Page<News> findHot(Pageable pageable);

    Long countNewsByStatus(boolean status);

    List<News> findByStatus(boolean status);
}
