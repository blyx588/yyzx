package com.neuedu.yyzx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.yyzx.pojo.Customer;
import com.neuedu.yyzx.vo.KhxxCustomerVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wyh
 * @since 2023-11-07
 */
public interface CustomerMapper extends BaseMapper<Customer> {
//    Page<KhxxCustomerVo> selectPageVo(@Param("page") Page<KhxxCustomerVo> page, @Param("customerName")
//            String customerName,@Param("manType") Integer manType,@Param("userId") Integer userId);

//    Page<KhxxCustomerVo> selectVo(@Param("page")Page<KhxxCustomerVo> page, @Param("userId")Integer userId);
}
