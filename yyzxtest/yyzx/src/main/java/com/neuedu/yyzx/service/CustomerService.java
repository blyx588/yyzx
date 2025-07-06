package com.neuedu.yyzx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.yyzx.dto.CustomerDTO;
import com.neuedu.yyzx.pojo.Bed;
import com.neuedu.yyzx.pojo.Customer;
import com.neuedu.yyzx.utils.ResultVo;
import com.neuedu.yyzx.vo.KhxxCustomerVo;

public interface CustomerService extends IService<Customer> {


//    ResultVo<Page<KhxxCustomerVo>> khxxFindCustomer(CustomerDTO customerDTO);
}
