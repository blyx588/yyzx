package com.neuedu.yyzx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.yyzx.mapper.CustomerMapper;
import com.neuedu.yyzx.mapper.NursingLevelMapper;
import com.neuedu.yyzx.pojo.Customer;
import com.neuedu.yyzx.pojo.NursingLevel;
import com.neuedu.yyzx.service.CustomerService;
import com.neuedu.yyzx.service.NursingLevelService;
import org.springframework.stereotype.Service;

@Service
public class NursingLevelServiceImpl extends ServiceImpl<NursingLevelMapper, NursingLevel> implements NursingLevelService {

//
//    @Override
//    public ResultVo<Page<KhxxCustomerVo>> khxxFindCustomer(CustomerDTO customerDTO) {
//        Page <KhxxCustomerVo> page = new Page<>(customerDTO.getPageSize(),6);
//        customerMapper.selectVo(page,customerDTO.getUserId());
//        return ResultVo.ok(page);
//    }
}
