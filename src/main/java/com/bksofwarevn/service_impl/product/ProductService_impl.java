package com.bksofwarevn.service_impl.product;

import com.bksofwarevn.entities.category.ProductSmallCategory;
import com.bksofwarevn.entities.product.Product;
import com.bksofwarevn.repository.product.ProductRepo;
import com.bksofwarevn.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ProductService_impl implements ProductService {

    private static final Logger LOGGER = Logger.getLogger(ProductService_impl.class.getName());

    @Autowired
    private ProductRepo productRepo;


    @Override
    public Product findById(int id) {
        try {
            return productRepo.findById(id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "find-by-id-error: {0}", ex.getMessage());
            return null;
        }
    }

    @Override
    public Page<Product> filter(ProductSmallCategory productSmallCategory, String name, Pageable pageable) {
        try {
            return productRepo.filter(productSmallCategory, name, pageable);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "filter-error: {0}", ex.getMessage());
            return null;
        }
    }

    @Override
    public Page<Product> findByCost(ProductSmallCategory productSmallCategory, String sort, Pageable pageable) {
        return null;
    }


    @Override
    public Page<Product> findNew(ProductSmallCategory productSmallCategory, Pageable pageable) {
        try {

            return productRepo.findNew(productSmallCategory, pageable);

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "find-new-error: {0}", ex.getMessage());
            return null;
        }
    }

    @Override
    public Page<Product> findHot(ProductSmallCategory productSmallCategory, Pageable pageable) {
        try {

            return productRepo.findHot(productSmallCategory, pageable);

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "find-hot-error: {0}", ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean save(Product product) {
        return false;
    }


    @Override
    public boolean update(Product product) {
        try {
            productRepo.save(product);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "update-error: {0}", ex.getMessage());
            return false;
        }
    }


    @Override
    public boolean delete(int id) {
        try {
            Product product = productRepo.findById(id);
            product.setStatus(false);
            productRepo.save(product);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "save-error: {0}", ex.getMessage());
            return false;
        }
    }

    @Override
    public Long countBySmall(ProductSmallCategory productSmallCategory) {
        try {
            return productRepo.countProductByProductSmallCategoryAndStatus(productSmallCategory, true);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "count-error: {0}", ex.getMessage());
            return null;
        }
    }

    @Override
    public Page<Product> findName(ProductSmallCategory productSmallCategory, String name, Pageable pageable) {
        try {
            return productRepo.findName(productSmallCategory, name, pageable);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "find-name-error: {0}", ex.getMessage());
            return null;
        }
    }

    @Override
    public Page<Product> findNameAll(String name, Pageable pageable) {
        try {
            return productRepo.findNameAll( name, pageable);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "find-name-error: {0}", ex.getMessage());
            return null;
        }
    }

    @Override
    public Long countByName(ProductSmallCategory productSmallCategory, String name) {
        try {
            return productRepo.countName(productSmallCategory, name);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "count-name-error: {0}", ex.getMessage());
            return null;
        }
    }

    @Override
    public Long countByNameAll(String name) {
        try {
            return productRepo.countNameAll(name);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "count-error: {0}", ex.getMessage());
            return null;
        }
    }

    @Override
    public Page<Product> findSale(ProductSmallCategory productSmallCategory, Pageable pageable) {
        try {
            return productRepo.findSale(productSmallCategory, pageable);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "find-sale-error: {0}", ex.getMessage());
            return null;
        }
    }

    @Override
    public Page<Product> findDistanc(ProductSmallCategory productSmallCategory, double min, double max, Pageable pageable, String sort) {
        try {
            if (sort.equalsIgnoreCase("DESC"))
                return productRepo.findDistanceHigh(productSmallCategory, min, max, pageable);
            return productRepo.findDistanceLow(productSmallCategory, min, max, pageable);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "find-distance-error: {0}", ex.getMessage());
            return null;
        }
    }

    @Override
    public Long countDistance(ProductSmallCategory productSmallCategory, double min, double max) {
        try {
            return productRepo.countDistance(productSmallCategory, min, max);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "count-distance-error: {0}", ex.getMessage());
            return null;
        }
    }
}
