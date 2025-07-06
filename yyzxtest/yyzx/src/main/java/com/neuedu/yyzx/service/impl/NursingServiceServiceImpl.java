package com.neuedu.yyzx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.yyzx.dto.NursingServiceDTO;
import com.neuedu.yyzx.mapper.LevelItemMapper;
import com.neuedu.yyzx.mapper.NursingServiceMapper;
import com.neuedu.yyzx.pojo.NursingService;

import com.neuedu.yyzx.service.NursingServiceService;
import com.neuedu.yyzx.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class NursingServiceServiceImpl extends ServiceImpl<NursingServiceMapper, NursingService> implements NursingServiceService {
    @Autowired
    private NursingServiceMapper nursingServiceMapper;
    @Autowired
    private LevelItemMapper levelItemMapper;
    @Override
    public ResultVo<Page<NursingService>> findNursingServicePage(NursingServiceDTO nursingServiceDTO) {
        Page<NursingService> page = new Page<>(nursingServiceDTO.getPageSize(),6);
        nursingServiceMapper.selectNursingServiceById(page,nursingServiceDTO.getLevelId());
        return ResultVo.ok(page);
    }

    @Override
    public ResultVo<List<NursingService>> findNursingService(NursingServiceDTO nursingServiceDTO) {
        List<NursingService> list = nursingServiceMapper.selectNursingServiceByIdNoPage(nursingServiceDTO.getLevelId());
        return ResultVo.ok(list);
    }

}
