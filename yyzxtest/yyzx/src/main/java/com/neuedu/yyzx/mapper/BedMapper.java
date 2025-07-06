package com.neuedu.yyzx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neuedu.yyzx.pojo.Bed;
import com.neuedu.yyzx.vo.CwsyBedVo;


public interface BedMapper extends BaseMapper<Bed> {
    CwsyBedVo selectBedCount();
}
