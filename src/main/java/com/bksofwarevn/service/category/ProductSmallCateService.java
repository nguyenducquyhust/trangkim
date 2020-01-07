package com.bksofwarevn.service.category;


import com.bksofwarevn.entities.category.ProductBigCategory;
import com.bksofwarevn.entities.category.ProductSmallCategory;

import java.util.List;

public interface ProductSmallCateService {

    ProductSmallCategory findById(int id);

    List<ProductSmallCategory> findByBig(ProductBigCategory productBigCategory);

    boolean save(ProductSmallCategory productSmallCategory);

    boolean delete(ProductSmallCategory productSmallCategory);
}
