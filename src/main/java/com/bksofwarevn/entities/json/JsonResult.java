package com.bksofwarevn.entities.json;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class JsonResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private String result;
    
    private Object data;


    public static JsonResult build(String result, Object data){
        
       return new JsonResult(result, data);
    }

}
