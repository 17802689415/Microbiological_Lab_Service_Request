package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.pojo.ApplyForm;
import com.it.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ApplyFormMapper extends BaseMapper<ApplyForm> {

    @Update("update apply_form set status = #{status} where case_num = #{caseNum}")
    void updateStatusByCaseNum(@Param("status") String status,@Param("caseNum") String caseNum);
}
