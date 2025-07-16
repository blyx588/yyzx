package com.health.system.service.impl;

import java.util.List;
import com.health.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.health.system.mapper.HospitalRatioLevel2Mapper;
import com.health.system.domain.HospitalRatioLevel2;
import com.health.system.service.IHospitalRatioLevel2Service;

/**
 * 二级医院报销比例Service业务层处理
 * 
 *  
 * @date 2025-07-09
 */
@Service
public class HospitalRatioLevel2ServiceImpl implements IHospitalRatioLevel2Service 
{
    @Autowired
    private HospitalRatioLevel2Mapper hospitalRatioLevel2Mapper;

    /**
     * 查询二级医院报销比例
     * 
     * @param id 二级医院报销比例主键
     * @return 二级医院报销比例
     */
    @Override
    public HospitalRatioLevel2 selectHospitalRatioLevel2ById(Long id)
    {
        return hospitalRatioLevel2Mapper.selectHospitalRatioLevel2ById(id);
    }

    /**
     * 查询二级医院报销比例列表
     * 
     * @param hospitalRatioLevel2 二级医院报销比例
     * @return 二级医院报销比例
     */
    @Override
    public List<HospitalRatioLevel2> selectHospitalRatioLevel2List(HospitalRatioLevel2 hospitalRatioLevel2)
    {
        return hospitalRatioLevel2Mapper.selectHospitalRatioLevel2List(hospitalRatioLevel2);
    }

    /**
     * 新增二级医院报销比例
     * 
     * @param hospitalRatioLevel2 二级医院报销比例
     * @return 结果
     */
    @Override
    public int insertHospitalRatioLevel2(HospitalRatioLevel2 hospitalRatioLevel2)
    {
        hospitalRatioLevel2.setCreateTime(DateUtils.getNowDate());
        return hospitalRatioLevel2Mapper.insertHospitalRatioLevel2(hospitalRatioLevel2);
    }

    /**
     * 修改二级医院报销比例
     * 
     * @param hospitalRatioLevel2 二级医院报销比例
     * @return 结果
     */
    @Override
    public int updateHospitalRatioLevel2(HospitalRatioLevel2 hospitalRatioLevel2)
    {
        hospitalRatioLevel2.setUpdateTime(DateUtils.getNowDate());
        return hospitalRatioLevel2Mapper.updateHospitalRatioLevel2(hospitalRatioLevel2);
    }

    /**
     * 批量删除二级医院报销比例
     * 
     * @param ids 需要删除的二级医院报销比例主键
     * @return 结果
     */
    @Override
    public int deleteHospitalRatioLevel2ByIds(Long[] ids)
    {
        return hospitalRatioLevel2Mapper.deleteHospitalRatioLevel2ByIds(ids);
    }

    /**
     * 删除二级医院报销比例信息
     * 
     * @param id 二级医院报销比例主键
     * @return 结果
     */
    @Override
    public int deleteHospitalRatioLevel2ById(Long id)
    {
        return hospitalRatioLevel2Mapper.deleteHospitalRatioLevel2ById(id);
    }
}
