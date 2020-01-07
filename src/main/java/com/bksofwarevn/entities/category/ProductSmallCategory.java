package com.bksofwarevn.entities.category;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Table(name = "product_small_category")
public class ProductSmallCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "big_category_id",nullable = false)
    @NotNull
    private ProductBigCategory productBigCategory;

    @NotNull
    private boolean status;


    public boolean setStatus(boolean b) {
        return status;
    }
}
