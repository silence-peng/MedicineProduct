package com.ht.mapper.dataMapper;

import com.ht.pojo.NationalStandard;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("nationalStandardMapper")
public interface NationalStandardMapper extends Mapper<NationalStandard> {
}
