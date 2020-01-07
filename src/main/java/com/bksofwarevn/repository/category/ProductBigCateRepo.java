package com.bksofwarevn.repository.category;


import com.bksofwarevn.entities.category.ProductBigCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductBigCateRepo extends JpaRepository<ProductBigCategory, Integer> {

    List<ProductBigCategory> findByStatus(boolean status);

    ProductBigCategory findById(int id);

}
