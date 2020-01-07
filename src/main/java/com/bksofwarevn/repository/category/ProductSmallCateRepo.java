package com.bksofwarevn.repository.category;

import com.bksofwarevn.entities.category.ProductBigCategory;
import com.bksofwarevn.entities.category.ProductSmallCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSmallCateRepo extends JpaRepository<ProductSmallCategory, Integer> {

    List<ProductSmallCategory> findByStatus(boolean status);

    ProductSmallCategory findById(int id);

    @Query(value = "select c from ProductSmallCategory  c where c.productBigCategory = ?1 and c.status = true")
    List<ProductSmallCategory> findByProductBigCategory(ProductBigCategory productBigCategory);
}
