package com.neuedu.yyzx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.yyzx.pojo.CustomerNurseItem;
import com.neuedu.yyzx.vo.NurseItemCustomerVo;
import org.apache.ibatis.annotations.Param;

public interface CustomerNurseItemMapper extends BaseMapper<CustomerNurseItem> {
    Page<NurseItemCustomerVo> getNurseItemByCustomer(@Param("page")Page<NurseItemCustomerVo> page,@Param("customerId") Integer customerId,@Param("itemId") Integer itemId);
}
