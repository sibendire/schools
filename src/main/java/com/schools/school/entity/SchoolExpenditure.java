package com.schools.school.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class SchoolExpenditure {
    @Id
    private Long id;
    private LocalDate localDate;
    private Long quantity;
    private String quality;
    private String itemName;
    private double unitCost;
    private double totalAmount;
    private String takenBy;

}
