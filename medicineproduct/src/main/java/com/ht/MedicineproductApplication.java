package com.ht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.ht.mapper")//mapper
public class MedicineproductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicineproductApplication.class, args);
    }

}
