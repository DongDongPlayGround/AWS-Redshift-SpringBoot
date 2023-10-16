package com.dongdong.redshift;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Integer price;

  private Long categoryId;

  public static Product create(String name,
                               Integer price,
                               Long categoryId){
    return Product.builder()
      .name(name)
      .price(price)
      .categoryId(categoryId)
      .build();
  }
}
