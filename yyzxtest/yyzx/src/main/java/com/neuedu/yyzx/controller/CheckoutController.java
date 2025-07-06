package com.neuedu.yyzx.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.yyzx.dto.CheckoutDTO;
import com.neuedu.yyzx.pojo.Checkout;
import com.neuedu.yyzx.service.CheckoutService;
import com.neuedu.yyzx.utils.ResultVo;
import com.neuedu.yyzx.vo.CheckoutVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkout")
@CrossOrigin
@Api(tags = "外出登记")
public class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;


    @ApiOperation("添加外出记录")
    @PostMapping("/addRecords")
    public ResultVo addRecords(Checkout checkout) {
        checkout.setIsDeleted(0);
        checkout.setAuditStatus(0);
        checkoutService.save(checkout);
        return ResultVo.ok("添加成功");
    }

//    @ApiOperation("登记信息查询")
//    @PostMapping("/viewCheckout")
//    public ResultVo<Page<Checkout>> queryCheckoutPage(CheckoutDTO checkoutDTO) throws Exception{
//
//    }
//
    @ApiOperation("查询全部用户-分页")
    @GetMapping("/findAllCheckoutPage")
    public ResultVo<Page<CheckoutVo>> listCheckoutVoPage(CheckoutDTO checkoutDTO) throws Exception{
        return checkoutService.listCheckoutVoPage(checkoutDTO);
    }

    @ApiOperation("审批申请")
    @PostMapping("/examineCheckout")
    public ResultVo examineCheckout(Checkout checkout) throws Exception{
        return checkoutService.examineCheckout(checkout);
    }

    @ApiOperation("撤回申请")
    @PostMapping("/recallApplication")
    public ResultVo recallApplication(Checkout checkout) throws Exception{
        UpdateWrapper<Checkout> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("is_deleted", 1);
        updateWrapper.eq("id",checkout.getId());
        checkoutService.update(checkout,updateWrapper);
        return ResultVo.ok("修改成功");
    }


    @PostMapping("/updateActualBackTime")
    public ResultVo UpdateActualBackTime(Checkout checkout) throws Exception{
        UpdateWrapper<Checkout> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",checkout.getId());
        checkoutService.update(checkout,updateWrapper);
        return ResultVo.ok("修改成功");
    }
}
