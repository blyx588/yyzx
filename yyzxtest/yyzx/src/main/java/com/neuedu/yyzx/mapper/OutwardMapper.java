package com.neuedu.yyzx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.yyzx.dto.BedDetailsDTO;
import com.neuedu.yyzx.dto.OutwardDTO;
import com.neuedu.yyzx.pojo.Outward;
import com.neuedu.yyzx.vo.BedDetailsVo;
import com.neuedu.yyzx.vo.OutwardVo;
import org.apache.ibatis.annotations.Param;

public interface OutwardMapper extends BaseMapper<Outward> {
    Page<OutwardVo> selectOutwardVo(@Param("page") Page<OutwardVo> page, @Param("userId") Integer userId);
}
