package com.ht.mapper.dataMapper;

import com.ht.pojo.Department;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("departmentMapper")
public interface DepartmentMapper extends Mapper<Department> {
}
