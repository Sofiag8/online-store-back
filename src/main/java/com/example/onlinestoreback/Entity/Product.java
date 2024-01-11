package com.example.onlinestoreback.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
@Table(name = "products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
	@Size(min=2, max=30)
  private String name;

  @NotNull
	@Size(min=20, max=30)
  private String description;

  @NotNull
  private Integer price;

  private String imageUrl;

  @NotNull
	@Size(min=2, max=30)
  private String branch;
}
