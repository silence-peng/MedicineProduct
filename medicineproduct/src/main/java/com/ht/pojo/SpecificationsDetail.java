package com.ht.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)//链式写法
public class SpecificationsDetail implements Serializable {
    private Integer sdid;
    private Integer sid;
    private Integer departmentId;
    private Integer bedNum;
    private Integer roomNum;
    private Integer oxygenMaxOutputPower;
    private Integer oxygenMinOutputPower;
    private Integer vacuumMaxOutputPower;
    private Integer vacuumMinOutputPower;
    private Integer airMaxOutputPower;
    private Integer airMinOutputPower;
}
