package com.bksofwarevn.repository.product;


import com.bksofwarevn.entities.category.ProductSmallCategory;
import com.bksofwarevn.entities.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    Product findById(int id);

    @Query(value = "select p from Product p where p.productSmallCategory = ?1 and p.name like concat('%',?2,'%') and p.status = true ")
    Page<Product> filter(ProductSmallCategory productSmallCategory, String name, Pageable pageable);

    @Query(value = "select p from Product p where p.productSmallCategory = ?1 and p.status = true order by p.saleCost DESC ")
    Page<Product> findHighCost(ProductSmallCategory productSmallCategory, Pageable pageable);

    @Query(value = "select p from Product p where p.productSmallCategory = ?1 and p.status = true order by p.saleCost ASC ")
    Page<Product> findLowCost(ProductSmallCategory productSmallCategory, Pageable pageable);

    @Query(value = "select p from Product p where p.productSmallCategory = ?1 and p.status = true order by p.initDate DESC ")
    Page<Product> findNew(ProductSmallCategory productSmallCategory, Pageable pageable);

    @Query(value = "select p from Product p where p.productSmallCategory = ?1 and p.status = true order by p.viewCount DESC ")
    Page<Product> findHot(ProductSmallCategory productSmallCategory, Pageable pageable);

    Long countProductByProductSmallCategoryAndStatus(ProductSmallCategory productSmallCategory, boolean status);

    @Query(value = "select p from Product p where p.productSmallCategory = ?1 and p.status = true and p.name like concat('%',?2,'%') order by p.name asc ")
    Page<Product> findName(ProductSmallCategory productSmallCategory, String name, Pageable pageable);

    @Query(value = "select p from Product p where p.productSmallCategory = ?1 and p.status = true order by ( p.originCost - p.saleCost) / (p.originCost + 1) DESC ")
    Page<Product> findSale(ProductSmallCategory productSmallCategory, Pageable pageable);

    @Query(value = "select count(p) from  Product p where p.productSmallCategory = ?1 and p.status = true and p.name like concat('%',?2,'%')")
    Long countName(ProductSmallCategory productSmallCategory, String name);

    @Query(value = "select count(p) from  Product p where  p.status = true and p.name like concat('%',?1,'%')")
    Long countNameAll(String name);

    @Query(value = "select p from Product p where p.status = true and p.name like concat('%',?1,'%') order by p.name asc ")
    Page<Product> findNameAll(String name, Pageable pageable);

    @Query(value = "select p from Product p where p.productSmallCategory = ?1 and p.status = true and (p.saleCost >= ?2 and p.saleCost <= ?3) order by p.saleCost desc ")
    Page<Product> findDistanceHigh(ProductSmallCategory productSmallCategory, double minCost, double maxCost, Pageable pageable);

    @Query(value = "select p from Product p where p.productSmallCategory = ?1 and p.status = true and (p.saleCost >= ?2 and p.saleCost <= ?3) order by p.saleCost asc ")
    Page<Product> findDistanceLow(ProductSmallCategory productSmallCategory, double minCost, double maxCost, Pageable pageable);

    @Query(value = "select count(p) from Product p where p.productSmallCategory = ?1 and p.status = true and (p.saleCost >= ?2 and p.saleCost <= ?3)")
    Long countDistance(ProductSmallCategory productSmallCategory, double minCost, double maxCost);

    List<Product> findByProductSmallCategoryAndStatus(ProductSmallCategory productSmallCategory, boolean status);
}
