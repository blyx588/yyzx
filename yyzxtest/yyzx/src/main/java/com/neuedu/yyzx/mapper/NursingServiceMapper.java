package com.neuedu.yyzx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.yyzx.pojo.NursingService;

import java.util.List;


public interface NursingServiceMapper extends BaseMapper<NursingService> {

    Page<NursingService> selectNursingServiceById(Page<NursingService> page, Integer levelId);

    List<NursingService> selectNursingServiceByIdNoPage(Integer levelId);
}
