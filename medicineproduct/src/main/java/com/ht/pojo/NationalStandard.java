package com.ht.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "national_standard")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)//链式写法
public class NationalStandard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  nid;//
    private Integer departmentId;
    private Integer oxygenMaxOutput;
    private Integer oxygenMinOutput;
    private Integer oxygenAvailability;
    private Integer airMaxOutput;
    private Integer airMinOutput;
    private Integer airAvailability;
    private Integer vacuumMaxOutput;
    private Integer vacuumMinOutput;
    private Integer vacuumAvailability;
}
