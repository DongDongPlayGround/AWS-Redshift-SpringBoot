package com.dongdong.redshift;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ProductTest {

  Logger log = LoggerFactory.getLogger(ProductTest.class);

  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private CategoryRepository categoryRepository;

  ProductDummy productDummy = new ProductDummy();
  CategoryDummy categoryDummy = new CategoryDummy();

  void createProduct() {

    productDummy.getShirts(categoryRepository.save(categoryDummy.getShirtsCategory()).getId());
    productDummy.getSweater(categoryRepository.save(categoryDummy.getSweaterCategory()).getId());

    productDummy.getJeans(categoryRepository.save(categoryDummy.getJeansCategory()).getId());
    productDummy.getTrainingPants(categoryRepository.save(categoryDummy.getTrainingPantsCategory()).getId());

    productDummy.getSocks(categoryRepository.save(categoryDummy.getSocksCategory()).getId());
    productDummy.getShoes(categoryRepository.save(categoryDummy.getShoesCategory()).getId());
  }

  Category getSocksCategory() {
    return categoryRepository.save(categoryDummy.getSocksCategory());
  }
  Category getShoesCategory(){
    return categoryRepository.save(categoryDummy.getShoesCategory());
  }

  Category getJeansCategory(){
    return categoryRepository.save(categoryDummy.getJeansCategory());
  }

  Category getTrainingPantsCategory(){
    return categoryRepository.save(categoryDummy.getTrainingPantsCategory());
  }

  Category getShirtsCategory(){
    return categoryRepository.save(categoryDummy.getShirtsCategory());
  }

  Category getSweaterCategory(){
    return categoryRepository.save(categoryDummy.getSweaterCategory());
  }

  @Test
  void registerParentTest() {
    Category category = new Category();
    Category shirtsCategory = getShirtsCategory();
    Category sweaterCategory = getSweaterCategory();
    Category top = category.create("상의", null, List.of(shirtsCategory, sweaterCategory));
    Category savedTop = categoryRepository.save(top);

    assertNull(savedTop.getParent());
    assertEquals(savedTop.getName(), "상의");
    savedTop.getChild().forEach(
      value -> {
        log.info("value name : {}", value.getName());
      });
  }

  @Test
  void registerParentErrorTest() {

  }

  @Test
  void addChildTest() {
    Category category = new Category();
    Category pants = category.create("하의", null, List.of(getJeansCategory(), getTrainingPantsCategory()));
    Category savedPants = categoryRepository.save(pants);

    assertNull(savedPants.getParent());
    assertEquals(savedPants.getName(), "하의");
    savedPants.getChild().forEach(
      value -> {
        log.info("value name : {}", value.getName());
      });
  }

  @Test
  void addChildErrorTest() {
    Category category = new Category();
    Category jeansCategory = getJeansCategory();
    Category trainingPantsCategory = getTrainingPantsCategory();
    Category pants = category.create("상의", null, List.of(jeansCategory, trainingPantsCategory));
    Category savedPants = categoryRepository.save(pants);

    assertThrows(RuntimeException.class,
      () -> savedPants.addChild(List.of(jeansCategory)));
  }
}
