package com.bksofwarevn.service.product;


import com.bksofwarevn.entities.product.BuyForm;
import com.bksofwarevn.entities.product.ProductHasBuyForm;

import java.util.List;

public interface ProductHasBuyFormService {

    ProductHasBuyForm findById(int id);

    List<ProductHasBuyForm> findByBuyForm(BuyForm buyForm);

    boolean save(ProductHasBuyForm productHasBuyForm);
}
