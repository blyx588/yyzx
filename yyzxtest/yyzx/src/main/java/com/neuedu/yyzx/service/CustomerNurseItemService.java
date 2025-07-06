package com.neuedu.yyzx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.yyzx.controller.CustomerNurseItemController;
import com.neuedu.yyzx.dto.NurseItemByCustomerDTO;
import com.neuedu.yyzx.dto.NurseRecordDTO;
import com.neuedu.yyzx.pojo.CustomerNurseItem;
import com.neuedu.yyzx.pojo.NurseRecord;
import com.neuedu.yyzx.utils.ResultVo;
import com.neuedu.yyzx.vo.NurseItemCustomerVo;

public interface CustomerNurseItemService extends IService<CustomerNurseItem> {
    ResultVo<Page<NurseItemCustomerVo>> getNurseItemByCustomer(NurseItemByCustomerDTO nurseItemByCustomerDTO);


}
