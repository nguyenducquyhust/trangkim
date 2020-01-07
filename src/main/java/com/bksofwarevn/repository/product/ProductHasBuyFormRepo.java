package com.bksofwarevn.repository.product;

import com.bksofwarevn.entities.product.BuyForm;
import com.bksofwarevn.entities.product.ProductHasBuyForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductHasBuyFormRepo extends JpaRepository<ProductHasBuyForm, Integer> {

    ProductHasBuyForm findById(int id);

    List<ProductHasBuyForm> findByBuyForm(BuyForm buyForm);
}
