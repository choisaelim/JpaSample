package com.example.jpasample.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
import javax.persistence.OneToOne;

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

  // @ManyToOne(fetch = FetchType.LAZY)
  // @JoinColumn(name = "MEMBER_ID")
  // private Member member;

  // Order - OrderItem 1:* 관계이므로 Order는 onetomany,
  // List는 초기화
  // persist remove 등 > cascadetype.all 사용
  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<OrderItem> orderItems = new ArrayList<OrderItem>();

  // mappedby 빠져야 되는지?
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Delivery delivery;

  private LocalDateTime orderDate;

  // Enum > String으로
  @Enumerated(EnumType.STRING)
  private OrderStatus status;
}
