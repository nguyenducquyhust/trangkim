package com.bksofwarevn.service.category;


import com.bksofwarevn.entities.category.ProductBigCategory;

import java.util.List;

public interface ProductBigCateService {

    ProductBigCategory findById(int id);

    List<ProductBigCategory> findAll();

    boolean save(ProductBigCategory productBigCategory);

    boolean delete(ProductBigCategory productBigCategory);
}
