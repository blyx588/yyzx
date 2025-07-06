package com.neuedu.yyzx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.yyzx.pojo.Checkout;
import com.neuedu.yyzx.vo.CheckoutVo;
import com.neuedu.yyzx.vo.CheckoutVo;
import org.apache.ibatis.annotations.Param;

public interface CheckoutMapper extends BaseMapper<Checkout> {
    Page<CheckoutVo> selectCheckoutVo(@Param("page") Page<CheckoutVo> page, @Param("userId") Integer userId);
}
