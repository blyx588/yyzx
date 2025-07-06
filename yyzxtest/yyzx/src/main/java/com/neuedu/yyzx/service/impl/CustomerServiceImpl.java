package com.neuedu.yyzx.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.neuedu.yyzx.mapper.BedMapper;
import com.neuedu.yyzx.mapper.CustomerMapper;
import com.neuedu.yyzx.pojo.Bed;
import com.neuedu.yyzx.pojo.Customer;
import com.neuedu.yyzx.service.BedService;
import com.neuedu.yyzx.service.CustomerService;
import com.neuedu.yyzx.utils.ResultVo;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

//    @Override
//    public ResultVo<Page<KhxxCustomerVo>> khxxFindCustomer(CustomerDTO customerDTO) {
//        Page <KhxxCustomerVo> page = new Page<>(customerDTO.getPageSize(),6);
//        customerMapper.selectVo(page,customerDTO.getUserId());
//        return ResultVo.ok(page);
//    }
}
