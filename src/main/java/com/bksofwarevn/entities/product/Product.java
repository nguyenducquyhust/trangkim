package com.bksofwarevn.entities.product;

import com.bksofwarevn.entities.category.ProductSmallCategory;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    @Column(name = "origin_cost")
    @NotNull
    private double originCost;

    @Column(name = "sale_cost")
    private double saleCost;

    private String image;

    private String trademark;

    private String description;

    @Column(name = "mini_description")
    private String miniDescription;

    @Column(name = "init_date")
    private String initDate;

    @Column(name = "view_count")
    private int viewCount;

    @Column(name = "product_status")
    private boolean productStatus;

    private boolean status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_small_category_id", nullable = false)
    private ProductSmallCategory productSmallCategory;


    public boolean setStatus(boolean b) {
        return  status;
    }

}
