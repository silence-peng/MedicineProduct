package com.ht.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Table(name = "national_standard")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)//链式写法
public class NationalStandard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  nid;//
    @Column(name = "department_id")
    private Integer departmentId;
    @Column(name = "oxygen_max_output")
    private int oxygenMaxOutput;
    @Column(name = "oxygen_min_output")
    private int oxygenMinOutput;
    @Column(name = "oxygen_availability")
    private int oxygenAvailability;
    @Column(name = "air_max_output")
    private int airMaxOutput;
    @Column(name = "air_min_output")
    private int airMinOutput;
    @Column(name = "air_availability")
    private int airAvailability;
    @Column(name = "vacuum_max_output")
    private int vacuumMaxOutput;
    @Column(name = "vacuum_min_output")
    private int vacuumMinOutput;
    @Column(name = "vacuum_availability")
    private int vacuumAvailability;
    //     data.airMaxOutputPower=airMaxOutPutPower/100;
//    data.=airMinOutPutPower/100;
//    data.oxygenMaxOutputPower=oxygenMaxOutPutPower/100;
//    data.oxygenMinOutputPower=oxygenMinOutPutPower/100;
//    data.vacuumMaxOutputPower=vacuumMaxOutputPower/100;
//    data.vacuumMinOutputPower=vacuumMinOutputPower/100;
}
