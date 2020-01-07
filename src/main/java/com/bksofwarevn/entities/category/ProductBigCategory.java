package com.bksofwarevn.entities.category;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Getter
@Setter
@Table(name = "product_big_category")
public class ProductBigCategory implements Serializable {

    private static final long serialVersionUID = 1L;//dam bao cac đối tượng trước và sau khi serializable là 1

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    private boolean status;

    public boolean setStatus(boolean b) {
        return  status;
    }
}
