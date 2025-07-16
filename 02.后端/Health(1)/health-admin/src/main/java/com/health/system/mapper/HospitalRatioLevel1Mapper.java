package com.health.system.mapper;

import java.util.List;

import com.health.common.enums.OperationType;
import com.health.system.annotation.AutoFill;
import com.health.system.domain.HospitalRatioLevel1;

/**
 * 一级医院报销比例Mapper接口
 *
 *  
 * @date 2025-07-09
 */
public interface HospitalRatioLevel1Mapper
{
    /**
     * 查询一级医院报销比例
     *
     * @param id 一级医院报销比例主键
     * @return 一级医院报销比例
     */
    public HospitalRatioLevel1 selectHospitalRatioLevel1ById(Long id);

    /**
     * 查询一级医院报销比例列表
     *
     * @param hospitalRatioLevel1 一级医院报销比例
     * @return 一级医院报销比例集合
     */
    public List<HospitalRatioLevel1> selectHospitalRatioLevel1List(HospitalRatioLevel1 hospitalRatioLevel1);

    /**
     * 新增一级医院报销比例
     *
     * @param hospitalRatioLevel1 一级医院报销比例
     * @return 结果
     */
    @AutoFill(value = OperationType.INSERT)
    public int insertHospitalRatioLevel1(HospitalRatioLevel1 hospitalRatioLevel1);

    /**
     * 修改一级医院报销比例
     *
     * @param hospitalRatioLevel1 一级医院报销比例
     * @return 结果
     */
    @AutoFill(value = OperationType.UPDATE)
    public int updateHospitalRatioLevel1(HospitalRatioLevel1 hospitalRatioLevel1);

    /**
     * 删除一级医院报销比例
     *
     * @param id 一级医院报销比例主键
     * @return 结果
     */
    public int deleteHospitalRatioLevel1ById(Long id);

    /**
     * 批量删除一级医院报销比例
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHospitalRatioLevel1ByIds(Long[] ids);
}
