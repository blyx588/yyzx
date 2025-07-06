package com.neuedu.yyzx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.yyzx.dto.CustomerNurseItemDTO;
import com.neuedu.yyzx.dto.DeletedNurseItem;
import com.neuedu.yyzx.dto.NurseItemByCustomerDTO;
import com.neuedu.yyzx.dto.NursingLevelDTO;
import com.neuedu.yyzx.pojo.Customer;
import com.neuedu.yyzx.pojo.CustomerNurseItem;
import com.neuedu.yyzx.pojo.NursingLevel;
import com.neuedu.yyzx.service.CustomerNurseItemService;
import com.neuedu.yyzx.utils.ResultVo;
import com.neuedu.yyzx.vo.NurseItemCustomerVo;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerNurseItem")
@CrossOrigin
public class CustomerNurseItemController {
    @Autowired
    CustomerNurseItemService customerNurseItemService;

    @ApiOperation("查询全部用户-分页")
    @GetMapping("/findAllCustomerNurseItemPage")
    public ResultVo<Page<CustomerNurseItem>> findAllCustomerNurseItemPage(CustomerNurseItemDTO customerNurseItemDTO) throws Exception{
        Page<CustomerNurseItem> page=new Page<>(customerNurseItemDTO.getPageSize(),7);
        QueryWrapper qw = new QueryWrapper();
        qw.eq("level_id",customerNurseItemDTO.getLevelId());
        customerNurseItemService.page(page,qw);
        return ResultVo.ok(page);
    }

@PostMapping("/saveCustomerNurseItem")
    public ResultVo saveCustomerNurseItem(@RequestBody List<CustomerNurseItem> customerNurseItem) throws Exception{
        if(!customerNurseItem.isEmpty()){
            for (CustomerNurseItem nurseItem : customerNurseItem) {
                customerNurseItemService.save(nurseItem);
            }
        }
        return ResultVo.ok("添加成功");
    }
    @PostMapping("/deleted")
    public ResultVo deleted(DeletedNurseItem deletedNurseItem) throws Exception{
        UpdateWrapper<CustomerNurseItem> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("is_deleted",1);
        updateWrapper.eq("customer_id",deletedNurseItem.getCustomerId());
        customerNurseItemService.update(updateWrapper);
        return ResultVo.ok("删除成功");
    }

    @GetMapping("/getNurseItemByCustomer")
    public ResultVo<Page<NurseItemCustomerVo>> getNurseItemByCustomer(NurseItemByCustomerDTO nurseItemByCustomerDTO) throws Exception{
        return customerNurseItemService.getNurseItemByCustomer(nurseItemByCustomerDTO);
    }
}
