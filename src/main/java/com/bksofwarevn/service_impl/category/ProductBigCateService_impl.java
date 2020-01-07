package com.bksofwarevn.service_impl.category;


import com.bksofwarevn.entities.category.ProductBigCategory;
import com.bksofwarevn.entities.category.ProductSmallCategory;
import com.bksofwarevn.repository.category.ProductBigCateRepo;
import com.bksofwarevn.repository.category.ProductSmallCateRepo;
import com.bksofwarevn.service.category.ProductBigCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ProductBigCateService_impl implements ProductBigCateService {

    private static final Logger LOGGER = Logger.getLogger(ProductBigCateService_impl.class.getName());

    @Autowired
    private ProductBigCateRepo productBigCateRepo;
    @Autowired
    private ProductSmallCateRepo productSmallCateRepo;

    @Override
    public ProductBigCategory findById(int id) {
        try {
            return productBigCateRepo.findById(id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "find-by-id-error: {0}", ex.getMessage());
            return null;
        }
    }

    @Override
    public List<ProductBigCategory> findAll() {
        try {
            return productBigCateRepo.findByStatus(true);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "find-all-error: {0}", ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean save(ProductBigCategory productBigCategory) {
        try {
            productBigCateRepo.save(productBigCategory);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "save-error: {0}", ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(ProductBigCategory productBigCategory) {
        try {
            productBigCategory.setStatus(false);
            productBigCateRepo.save(productBigCategory);
            List<ProductSmallCategory> productSmallCategories = productSmallCateRepo.findByProductBigCategory(productBigCategory);
            productSmallCategories.forEach(ps -> {
                ps.setStatus(false);
                productSmallCateRepo.save(ps);
            });
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "save-error: {0}", ex.getMessage());
            return false;
        }
    }
}
