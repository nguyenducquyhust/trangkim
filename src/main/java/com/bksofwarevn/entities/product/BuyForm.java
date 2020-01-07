package com.bksofwarevn.entities.product;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "buy_form")
public class BuyForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;

    private String address;

    private String phone;

    private String note;

    private boolean status;

    @Column(name = "init_date")
    private String initDate;

    private boolean checked;
}
