package com.dongdong.redshift;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class OrderProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long orderPrice;

  private Integer quantity;

  private Long storeId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id")
  private Order order;

  public static OrderProduct create(Long orderPrice, Integer quantity, Long storeId, Order order) {
    return OrderProduct.builder()
      .orderPrice(orderPrice)
      .quantity(quantity)
      .storeId(storeId)
      .order(order)
      .build();
  }
}
