package com.neuedu.yyzx.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.yyzx.dto.NurseItemByCustomerDTO;
import com.neuedu.yyzx.mapper.CustomerNurseItemMapper;
import com.neuedu.yyzx.mapper.NursingServiceMapper;
import com.neuedu.yyzx.pojo.CustomerNurseItem;
import com.neuedu.yyzx.service.CustomerNurseItemService;
import com.neuedu.yyzx.utils.ResultVo;
import com.neuedu.yyzx.vo.NurseItemCustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerNurseItemServiceImpl extends ServiceImpl<CustomerNurseItemMapper, CustomerNurseItem> implements CustomerNurseItemService {
    @Autowired
    private CustomerNurseItemMapper customerNurseItemMapper;
    @Override
    public ResultVo<Page<NurseItemCustomerVo>> getNurseItemByCustomer(NurseItemByCustomerDTO nurseItemByCustomerDTO) {
        Page<NurseItemCustomerVo> page = new Page<>(nurseItemByCustomerDTO.getPageSize(),6);
        customerNurseItemMapper.getNurseItemByCustomer(page, nurseItemByCustomerDTO.getCustomerId(),nurseItemByCustomerDTO.getItemId());
        return ResultVo.ok(page);
    }
}
