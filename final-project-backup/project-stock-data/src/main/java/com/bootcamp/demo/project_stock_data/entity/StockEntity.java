package com.bootcamp.demo.project_stock_data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Stocks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StockEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 20, nullable = false)
  private String symbol;
  @Column(length = 2, nullable = false)
  private String market; // US, HK, CY
  @Column(length = 1, name = "active_ind", nullable = false) // soft delete
  private String isActive; // Y, N
}
