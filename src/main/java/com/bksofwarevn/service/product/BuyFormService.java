package com.bksofwarevn.service.product;


import com.bksofwarevn.entities.product.BuyForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BuyFormService {

    BuyForm findById(int id);

    Page<BuyForm> findPage(Pageable pageable);

    Page<BuyForm> findNew(Pageable pageable);

    List<BuyForm> findAll();

    BuyForm save(BuyForm buyForm);
}
