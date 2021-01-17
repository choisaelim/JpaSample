package com.example.jpasample.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Item {

    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

}