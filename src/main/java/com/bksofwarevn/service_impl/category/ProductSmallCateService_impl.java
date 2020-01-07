package com.bksofwarevn.service_impl.category;


import com.bksofwarevn.entities.category.ProductBigCategory;
import com.bksofwarevn.entities.category.ProductSmallCategory;
import com.bksofwarevn.entities.product.Product;
import com.bksofwarevn.repository.category.ProductSmallCateRepo;
import com.bksofwarevn.repository.product.ProductRepo;
import com.bksofwarevn.service.category.ProductSmallCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ProductSmallCateService_impl implements ProductSmallCateService {

    private static final Logger LOGGER = Logger.getLogger(ProductSmallCateService_impl.class.getName());

    @Autowired
    private ProductSmallCateRepo productSmallCateRepo;
    @Autowired
    private ProductRepo productRepo;

    @Override
    public ProductSmallCategory findById(int id) {
        try {
            return productSmallCateRepo.findById(id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "find-by-id-error: {0}", ex.getMessage());
            return null;
        }
    }

    @Override
    public List<ProductSmallCategory> findByBig(ProductBigCategory productBigCategory) {
        try {
            return productSmallCateRepo.findByProductBigCategory(productBigCategory);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "find-by-big-error: {0}", ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean save(ProductSmallCategory productSmallCategory) {
        try {
            productSmallCateRepo.save(productSmallCategory);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "save-error: {0}", ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(ProductSmallCategory productSmallCategory) {
        try {
            productSmallCategory.setStatus(false);
            productSmallCateRepo.save(productSmallCategory);
            List<Product> products = productRepo.findByProductSmallCategoryAndStatus(productSmallCategory, true);
            products.forEach( p -> {
                p.setStatus(true);
                productRepo.save(p);
            });
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "save-error: {0}", ex.getMessage());
            return false;
        }
    }
}
