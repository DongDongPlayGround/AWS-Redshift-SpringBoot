package com.dongdong.redshift;

import lombok.*;
import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parent_id")
  private Category parent;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", orphanRemoval = true)
  @Builder.Default
  private List<Category> child = new ArrayList<>();

  public Category create(String name, @Nullable Category parent, @Nullable List<Category> child) {
    Category category = Category.builder()
      .name(name).build();
    return category.registerParent(parent).addChild(child);
  }

  public Category registerParent(Category parent) {
    if (this.parent != null) {
      throw new RuntimeException("already has parent!");
    }
    this.parent = parent;
    return this;
  }

  public Category addChild(List<Category> child) {
    if (hasSameChild(child)) {
      throw new RuntimeException("already exist child element!");
    }
    if(child != null){
      this.child.addAll(child);
      child.forEach(c -> c.registerParent(this));
    }
    return this;
  }

  private boolean hasSameChild(List<Category> child) {
    return !ObjectUtils.isEmpty(child) && child.stream().anyMatch(inputChild -> this.child.contains(inputChild));
  }

}
