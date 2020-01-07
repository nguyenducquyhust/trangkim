package com.bksofwarevn.controller.product;

import com.bksofwarevn.entities.json.JsonResult;
import com.bksofwarevn.entities.product.Product;
import com.bksofwarevn.service.category.ProductSmallCateService;
import com.bksofwarevn.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/public/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductSmallCateService productSmallCateService;

    @GetMapping("/")
    public String findById() {


        return "hi";
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<JsonResult> findById(@RequestParam("id") int id) {

        Product product = productService.findById(id);
        if (product != null) {
            return ResponseEntity.ok(JsonResult.build("ok", product));
        }
        return ResponseEntity.badRequest().build();
    }





}
