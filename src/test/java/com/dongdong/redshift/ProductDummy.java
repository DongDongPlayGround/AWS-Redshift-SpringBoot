package com.dongdong.redshift;

import java.util.List;

public class ProductDummy {

  public List<Product> getSocks(Long categoryId){
    return List.of(
      Product.create("양말 s", 3000, categoryId),
      Product.create("양말 m", 3500, categoryId),
      Product.create("양말 l", 4000, categoryId)
    );
  }

  public List<Product> getShirts(Long categoryId){
    return List.of(
      Product.create("분홍 셔츠", 20000, categoryId),
      Product.create("노랑 셔츠", 18000, categoryId),
      Product.create("파랑 셔츠", 29000, categoryId)
    );
  }
  public List<Product> getSweater(Long categoryId){
    return List.of(
      Product.create("서울 스웨터", 30000, categoryId),
      Product.create("뉴욕 스웨터", 27000, categoryId),
      Product.create("런던 스웨터", 26000, categoryId)
    );
  }
  public List<Product> getJeans(Long categoryId){
    return List.of(
      Product.create("연청", 22000, categoryId),
      Product.create("진청", 32000, categoryId),
      Product.create("흑청", 42000, categoryId)
    );
  }

  public List<Product> getTrainingPants(Long categoryId){
    return List.of(
      Product.create("정찬성 트레이닝바지", 67000, categoryId),
      Product.create("윤성빈 트레이닝바지", 80000, categoryId),
      Product.create("김종국 트레이닝바지", 65000, categoryId)
    );
  }

  public List<Product> getShoes(Long categoryId){
    return List.of(
      Product.create("구두", 230000, categoryId),
      Product.create("어글리슈즈", 190000, categoryId),
      Product.create("슬리퍼", 5000, categoryId)
    );
  }

}
