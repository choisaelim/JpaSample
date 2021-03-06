package com.example.jpasample.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;
    private String name;
    // private List<Item> items = new ArrayList<Item>();

}
