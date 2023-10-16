package com.dongdong.redshift;

public class CategoryDummy {

  public Category getSocksCategory(){
    Category category = new Category();
    return category.create("양말", null, null);
  }

  public Category getShirtsCategory(){
    Category category = new Category();
    return category.create("셔츠", null, null);
  }
  public Category getSweaterCategory(){
    Category category = new Category();
    return category.create("스웨터", null, null);
  }

  public Category getJeansCategory(){
    Category category = new Category();
    return category.create("청바지", null, null);
  }

  public Category getTrainingPantsCategory(){
    Category category = new Category();
    return category.create("트레이닝 하의", null, null);
  }

  public Category getShoesCategory(){
    Category category = new Category();
    return category.create("신발", null, null);
  }
}
