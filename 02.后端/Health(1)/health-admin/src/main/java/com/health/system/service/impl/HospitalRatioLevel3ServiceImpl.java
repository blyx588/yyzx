package com.health.system.service.impl;

import java.util.List;
import com.health.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.health.system.mapper.HospitalRatioLevel3Mapper;
import com.health.system.domain.HospitalRatioLevel3;
import com.health.system.service.IHospitalRatioLevel3Service;

/**
 * 三级医院报销比例Service业务层处理
 * 
 *  
 * @date 2025-07-09
 */
@Service
public class HospitalRatioLevel3ServiceImpl implements IHospitalRatioLevel3Service 
{
    @Autowired
    private HospitalRatioLevel3Mapper hospitalRatioLevel3Mapper;

    /**
     * 查询三级医院报销比例
     * 
     * @param id 三级医院报销比例主键
     * @return 三级医院报销比例
     */
    @Override
    public HospitalRatioLevel3 selectHospitalRatioLevel3ById(Long id)
    {
        return hospitalRatioLevel3Mapper.selectHospitalRatioLevel3ById(id);
    }

    /**
     * 查询三级医院报销比例列表
     * 
     * @param hospitalRatioLevel3 三级医院报销比例
     * @return 三级医院报销比例
     */
    @Override
    public List<HospitalRatioLevel3> selectHospitalRatioLevel3List(HospitalRatioLevel3 hospitalRatioLevel3)
    {
        return hospitalRatioLevel3Mapper.selectHospitalRatioLevel3List(hospitalRatioLevel3);
    }

    /**
     * 新增三级医院报销比例
     * 
     * @param hospitalRatioLevel3 三级医院报销比例
     * @return 结果
     */
    @Override
    public int insertHospitalRatioLevel3(HospitalRatioLevel3 hospitalRatioLevel3)
    {
        hospitalRatioLevel3.setCreateTime(DateUtils.getNowDate());
        return hospitalRatioLevel3Mapper.insertHospitalRatioLevel3(hospitalRatioLevel3);
    }

    /**
     * 修改三级医院报销比例
     * 
     * @param hospitalRatioLevel3 三级医院报销比例
     * @return 结果
     */
    @Override
    public int updateHospitalRatioLevel3(HospitalRatioLevel3 hospitalRatioLevel3)
    {
        hospitalRatioLevel3.setUpdateTime(DateUtils.getNowDate());
        return hospitalRatioLevel3Mapper.updateHospitalRatioLevel3(hospitalRatioLevel3);
    }

    /**
     * 批量删除三级医院报销比例
     * 
     * @param ids 需要删除的三级医院报销比例主键
     * @return 结果
     */
    @Override
    public int deleteHospitalRatioLevel3ByIds(Long[] ids)
    {
        return hospitalRatioLevel3Mapper.deleteHospitalRatioLevel3ByIds(ids);
    }

    /**
     * 删除三级医院报销比例信息
     * 
     * @param id 三级医院报销比例主键
     * @return 结果
     */
    @Override
    public int deleteHospitalRatioLevel3ById(Long id)
    {
        return hospitalRatioLevel3Mapper.deleteHospitalRatioLevel3ById(id);
    }
}
