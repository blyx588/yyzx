package com.neuedu.yyzx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.yyzx.dto.BedDetailsDTO;
import com.neuedu.yyzx.dto.OutwardDTO;
import com.neuedu.yyzx.pojo.Outward;
import com.neuedu.yyzx.utils.ResultVo;
import com.neuedu.yyzx.vo.BedDetailsVo;
import com.neuedu.yyzx.vo.OutwardVo;

public interface OutwardService extends IService<Outward> {
    ResultVo<Page<OutwardVo>> listOutwardVoPage(OutwardDTO outwardDTO) throws Exception;

    ResultVo examineOutward(Outward outward) throws Exception;
}
