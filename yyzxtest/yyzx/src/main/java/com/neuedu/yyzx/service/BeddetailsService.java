package com.neuedu.yyzx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.yyzx.dto.BedDetailsDTO;
import com.neuedu.yyzx.dto.ExchangeDTO;
import com.neuedu.yyzx.pojo.Beddetails;
import com.neuedu.yyzx.utils.ResultVo;
import com.neuedu.yyzx.vo.BedDetailsVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyh
 * @since 2023-11-06
 */
public interface BeddetailsService extends IService<Beddetails> {

    ResultVo<Page<BedDetailsVo>> listBedDetailsVoPage(BedDetailsDTO bedDetailsDTO) throws Exception;

    ResultVo exchangeBed(ExchangeDTO exchangeDTO) throws Exception;
}
