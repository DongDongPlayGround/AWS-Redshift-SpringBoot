package com.dongdong.redshift;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long totalPay;

  private Long totalQuantity;

  private Long userId;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", orphanRemoval = true)
  private List<OrderProduct> orderProducts = new ArrayList<>();

  public void addOrderProducts(List<OrderProduct> orderProducts){

  }
}
