package com.neuedu.yyzx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.yyzx.dto.NursingServiceDTO;
import com.neuedu.yyzx.pojo.NursingService;
import com.neuedu.yyzx.pojo.User;
import com.neuedu.yyzx.utils.ResultVo;

import java.util.List;

public interface NursingServiceService extends IService<NursingService> {

    ResultVo<Page<NursingService>> findNursingServicePage(NursingServiceDTO nursingServiceDTO);


    ResultVo<List<NursingService>> findNursingService(NursingServiceDTO nursingServiceDTO);
}
