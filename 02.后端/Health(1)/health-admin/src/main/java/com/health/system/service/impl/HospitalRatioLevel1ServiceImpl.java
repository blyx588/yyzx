package com.health.system.service.impl;

import java.util.List;
import com.health.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.health.system.mapper.HospitalRatioLevel1Mapper;
import com.health.system.domain.HospitalRatioLevel1;
import com.health.system.service.IHospitalRatioLevel1Service;

/**
 * 一级医院报销比例Service业务层处理
 * 
 *  
 * @date 2025-07-09
 */
@Service
public class HospitalRatioLevel1ServiceImpl implements IHospitalRatioLevel1Service 
{
    @Autowired
    private HospitalRatioLevel1Mapper hospitalRatioLevel1Mapper;

    /**
     * 查询一级医院报销比例
     * 
     * @param id 一级医院报销比例主键
     * @return 一级医院报销比例
     */
    @Override
    public HospitalRatioLevel1 selectHospitalRatioLevel1ById(Long id)
    {
        return hospitalRatioLevel1Mapper.selectHospitalRatioLevel1ById(id);
    }

    /**
     * 查询一级医院报销比例列表
     * 
     * @param hospitalRatioLevel1 一级医院报销比例
     * @return 一级医院报销比例
     */
    @Override
    public List<HospitalRatioLevel1> selectHospitalRatioLevel1List(HospitalRatioLevel1 hospitalRatioLevel1)
    {
        return hospitalRatioLevel1Mapper.selectHospitalRatioLevel1List(hospitalRatioLevel1);
    }

    /**
     * 新增一级医院报销比例
     * 
     * @param hospitalRatioLevel1 一级医院报销比例
     * @return 结果
     */
    @Override
    public int insertHospitalRatioLevel1(HospitalRatioLevel1 hospitalRatioLevel1)
    {
        hospitalRatioLevel1.setCreateTime(DateUtils.getNowDate());
        return hospitalRatioLevel1Mapper.insertHospitalRatioLevel1(hospitalRatioLevel1);
    }

    /**
     * 修改一级医院报销比例
     * 
     * @param hospitalRatioLevel1 一级医院报销比例
     * @return 结果
     */
    @Override
    public int updateHospitalRatioLevel1(HospitalRatioLevel1 hospitalRatioLevel1)
    {
        hospitalRatioLevel1.setUpdateTime(DateUtils.getNowDate());
        return hospitalRatioLevel1Mapper.updateHospitalRatioLevel1(hospitalRatioLevel1);
    }

    /**
     * 批量删除一级医院报销比例
     * 
     * @param ids 需要删除的一级医院报销比例主键
     * @return 结果
     */
    @Override
    public int deleteHospitalRatioLevel1ByIds(Long[] ids)
    {
        return hospitalRatioLevel1Mapper.deleteHospitalRatioLevel1ByIds(ids);
    }

    /**
     * 删除一级医院报销比例信息
     * 
     * @param id 一级医院报销比例主键
     * @return 结果
     */
    @Override
    public int deleteHospitalRatioLevel1ById(Long id)
    {
        return hospitalRatioLevel1Mapper.deleteHospitalRatioLevel1ById(id);
    }
}
