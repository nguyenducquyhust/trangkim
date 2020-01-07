package com.bksofwarevn.repository.product;

import com.bksofwarevn.entities.product.BuyForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyFormRepo extends JpaRepository<BuyForm, Integer> {

    BuyForm findById(int id);

    List<BuyForm> findByStatus(boolean status);

    @Query(value = "select b from  BuyForm  b where  b.status = true")
    Page<BuyForm> findPage(Pageable pageable);

    @Query(value = "select b from  BuyForm  b where  b.status = true order by b.initDate desc ")
    Page<BuyForm> findNew(Pageable pageable);
}
