package com.bksofwarevn.service.product;


import com.bksofwarevn.entities.category.ProductSmallCategory;
import com.bksofwarevn.entities.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Product findById(int id);

    Page<Product> filter(ProductSmallCategory productSmallCategory, String name, Pageable pageable);

    Page<Product> findByCost(ProductSmallCategory productSmallCategory, String sort, Pageable pageable);

    Page<Product> findNew(ProductSmallCategory productSmallCategory, Pageable pageable);

    Page<Product> findHot(ProductSmallCategory productSmallCategory, Pageable pageable);

    boolean save(Product product);

    boolean update(Product product);

    boolean delete(int id);

    Long countBySmall(ProductSmallCategory productSmallCategory);

    Page<Product> findName(ProductSmallCategory productSmallCategory, String name, Pageable pageable);

    Page<Product> findNameAll(String name, Pageable pageable);

    Long countByName(ProductSmallCategory productSmallCategory, String name);

    Long countByNameAll(String name);

    Page<Product> findSale(ProductSmallCategory productSmallCategory, Pageable pageable);

    Page<Product> findDistanc(ProductSmallCategory productSmallCategory, double min, double max, Pageable pageable, String sort);

    Long countDistance(ProductSmallCategory productSmallCategory, double min, double max);
}
