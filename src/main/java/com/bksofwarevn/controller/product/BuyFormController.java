package com.bksofwarevn.controller.product;

import com.bksofwarevn.entities.json.JsonResult;
import com.bksofwarevn.entities.product.BuyForm;
import com.bksofwarevn.service.product.BuyFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/public/buy-form")
public class BuyFormController {

    @Autowired
    private BuyFormService buyFormService;



    @GetMapping("/find-by-id")
    public ResponseEntity<Object> upload(@RequestParam("id") int id) {
        BuyForm buyForm = buyFormService.findById(id);
        if (buyForm != null)
            return ResponseEntity.ok(JsonResult.build("ok", buyForm));
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/find-all")
    public ResponseEntity<JsonResult> findAll(@RequestParam(name = "page", defaultValue = "1", required = false) int page,
                                              @RequestParam(name = "size", defaultValue = "100000", required = false) int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        List<BuyForm> buyForms = buyFormService.findNew(pageable).getContent();
        if (buyForms != null)
            return ResponseEntity.ok(JsonResult.build("ok", buyForms));
        return ResponseEntity.badRequest().build();
    }

}
