package com.neuedu.yyzx.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.yyzx.dto.CheckoutDTO;
import com.neuedu.yyzx.mapper.CheckoutMapper;
import com.neuedu.yyzx.pojo.Checkout;
import com.neuedu.yyzx.service.CheckoutService;
import com.neuedu.yyzx.utils.ResultVo;
import com.neuedu.yyzx.vo.CheckoutVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutServiceImpl extends ServiceImpl<CheckoutMapper, Checkout> implements CheckoutService {
    @Autowired
    private CheckoutMapper checkoutMapper;

    @Override
    public ResultVo<Page<CheckoutVo>> listCheckoutVoPage(CheckoutDTO checkoutDTO) throws Exception {
        Page<CheckoutVo> page=new Page<>(checkoutDTO.getPageSize(),6);
        checkoutMapper.selectCheckoutVo(page, checkoutDTO.getUserId());
        return ResultVo.ok(page);
    }

    @Override
    public ResultVo examineCheckout(Checkout checkout) throws Exception{
        UpdateWrapper<Checkout> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("audit_status",checkout.getAuditStatus());
        updateWrapper.eq("id",checkout.getId());
        checkoutMapper.update(checkout,updateWrapper);
        return ResultVo.ok("审批成功");
    }
}
