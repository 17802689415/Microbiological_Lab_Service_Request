package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.pojo.SampleForm;
import com.it.pojo.SampleTestInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleFormMapper extends BaseMapper<SampleForm> {
}