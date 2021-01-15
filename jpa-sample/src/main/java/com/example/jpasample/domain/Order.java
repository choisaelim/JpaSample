package com.example.jpasample.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.jpasample.type.OrderStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Order {
  @Id
  @GeneratedValue
  @Column(name = "ORDER_ID")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MEMBER_ID")
  private Member member;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<OrderItem> orderItems;

  // delivery

  private LocalDateTime orderDate;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;
}
