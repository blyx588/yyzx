package com.neuedu.yyzx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.yyzx.dto.CustDto;
import com.neuedu.yyzx.dto.CustomerDTO;
import com.neuedu.yyzx.dto.UpdateLevelIdCustomerDTO;
import com.neuedu.yyzx.dto.GetCustomerByUserIdDTO;
import com.neuedu.yyzx.pojo.Customer;
import com.neuedu.yyzx.service.CustomerService;
import com.neuedu.yyzx.utils.ResultVo;
import com.neuedu.yyzx.vo.KhxxCustomerVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer")
@CrossOrigin
@Api(tags = "客户管理")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @ApiOperation("添加客户")
    @PostMapping("/addCustomer")
    public ResultVo addCustomer(Customer customer) {
        customer.setIsDeleted(0);
        customerService.save(customer);
        return ResultVo.ok("添加成功");
    }

    @ApiOperation("修改客户")
    @PostMapping("/updateCustomer")
    public ResultVo updateCustomer(Customer customer) throws  Exception{
        UpdateWrapper<Customer> updateWrapper = new UpdateWrapper<Customer>();
        updateWrapper.eq("id",customer.getId());
        customerService.update(customer,updateWrapper);
        return ResultVo.ok("修改成功");
    }

    @ApiOperation("去除客户的管家")
    @PostMapping("/noSteward")
    public ResultVo noSteward(CustDto custDto) throws  Exception{
        UpdateWrapper<Customer> updateWrapper = new UpdateWrapper<>();
        Customer customer = new Customer();
        customer = customerService.getById(custDto.getId());
        updateWrapper.set("user_id",custDto.getUserId());
        updateWrapper.eq("id",customer.getId());
        customerService.update(customer,updateWrapper);
        return ResultVo.ok("修改成功");
    }



    @PostMapping("/updateLevelId")
    public ResultVo updateLevelId(UpdateLevelIdCustomerDTO updateLevelIdCustomerDTO) throws  Exception {
        UpdateWrapper<Customer> updateWrapper = new UpdateWrapper<>();
        Customer customer = new Customer();
        customer = customerService.getById(updateLevelIdCustomerDTO.getId());
        updateWrapper.set("level_id", updateLevelIdCustomerDTO.getLevelId());
        updateWrapper.eq("id", updateLevelIdCustomerDTO.getId());
        customerService.update(customer, updateWrapper);
        return ResultVo.ok("修改成功");
    }

    @ApiOperation("登记信息查询")
    @PostMapping("/viewCustomer")
    public ResultVo<Page<Customer>> findCustomerPage(CustomerDTO customerDTO) throws Exception{
        Page<Customer> page=new Page<>(customerDTO.getPageSize(),3);
        QueryWrapper qw=new QueryWrapper();
        if(customerDTO.getNickname()!=null && customerDTO.getNickname()!=""){
            qw.like("nickname","%"+customerDTO.getNickname()+"%");
        }
        qw.eq("role_id",customerDTO.getRoleId());
        qw.eq("is_deleted",0); //显示
        customerService.page(page,qw);
        return ResultVo.ok(page);
    }

    @ApiOperation("查询全部用户-分页")
    @GetMapping("/findAllCustomerPage")
    public ResultVo<Page<Customer> > findAllCustomerPage(CustomerDTO customerDTO) throws  Exception{
        Page<Customer> page=new Page<>(customerDTO.getPageSize(),7);
        QueryWrapper qw = new QueryWrapper();
        customerService.page(page,qw);
        return ResultVo.ok(page);
    }

    @GetMapping("/getCustomerByUserId")
    public  ResultVo<Page<Customer>> getCustomerByUserId(GetCustomerByUserIdDTO getCustomerByUserIdDTO) throws  Exception{
        Page<Customer> page = new Page<>(getCustomerByUserIdDTO.getPageSize(),6);
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id",getCustomerByUserIdDTO.getUserId());
        customerService.page(page,qw);
        return ResultVo.ok(page);
    }

    @ApiOperation("条件查询用户")
    @GetMapping("/listkhxxPage")
    public ResultVo<Page<KhxxCustomerVo>> listkhxxPage(CustomerDTO dto) throws Exception{
        QueryWrapper<Customer> wrapper = new QueryWrapper<>();
        // 添加动态条件
        wrapper.eq("user_Id",dto.getUserId());
        Page<Customer> page = new Page<>(dto.getPageSize(),6);
        customerService.page(page, wrapper);
        return ResultVo.ok(page);
    }

    @ApiOperation("删除客户")
    @GetMapping("/delCustomer")
    public ResultVo delCustomer(Integer id) throws  Exception{
        customerService.removeById(id);
        return ResultVo.ok("删除成功");
    }



    @PostMapping("/noLevel")
    public ResultVo noLevel(CustDto custDto) throws  Exception{
        UpdateWrapper<Customer> updateWrapper = new UpdateWrapper<>();
        Customer customer = new Customer();
        customer = customerService.getById(custDto.getId());
        updateWrapper.set("level_id",null);
        updateWrapper.eq("id",customer.getId());
        customerService.update(customer,updateWrapper);
        return ResultVo.ok("修改成功");
    }



}
