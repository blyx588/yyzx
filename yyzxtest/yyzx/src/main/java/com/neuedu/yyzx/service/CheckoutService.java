package com.neuedu.yyzx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.yyzx.dto.CheckoutDTO;
import com.neuedu.yyzx.pojo.Checkout;
import com.neuedu.yyzx.utils.ResultVo;
import com.neuedu.yyzx.vo.CheckoutVo;

public interface CheckoutService extends IService<Checkout> {
    ResultVo<Page<CheckoutVo>> listCheckoutVoPage(CheckoutDTO checkoutDTO) throws Exception;

    ResultVo examineCheckout(Checkout checkout) throws Exception;
}
