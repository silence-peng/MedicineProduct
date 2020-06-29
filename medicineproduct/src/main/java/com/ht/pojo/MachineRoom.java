package com.ht.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)//链式写法
public class MachineRoom  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer mid;//机房参照规格id
  private String fileName;//机房参考建设文档名
  private Integer oxygenMaxOutputPower;//氧气最大输出功率
  private Integer oxygenMinOutputPower;//氧气最小输出功率
  private Integer vacuumMaxOutputPower;//真空最大输出功率
  private Integer vacuumMinOutputPower;//真空最小输出功率
  private Integer airMaxOutputPower;//空气最大输出功率
  private Integer airMinOutputPower;//空气最小输出功率




}
