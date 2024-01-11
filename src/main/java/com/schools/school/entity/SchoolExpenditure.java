package com.schools.school.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
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
