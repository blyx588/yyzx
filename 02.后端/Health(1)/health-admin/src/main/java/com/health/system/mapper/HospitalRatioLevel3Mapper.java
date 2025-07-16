package com.health.system.mapper;

import java.util.List;

import com.health.common.enums.OperationType;
import com.health.system.annotation.AutoFill;
import com.health.system.domain.HospitalRatioLevel3;

/**
 * 三级医院报销比例Mapper接口
 *
 *  
 * @date 2025-07-09
 */
public interface HospitalRatioLevel3Mapper
{
    /**
     * 查询三级医院报销比例
     *
     * @param id 三级医院报销比例主键
     * @return 三级医院报销比例
     */
    public HospitalRatioLevel3 selectHospitalRatioLevel3ById(Long id);

    /**
     * 查询三级医院报销比例列表
     *
     * @param hospitalRatioLevel3 三级医院报销比例
     * @return 三级医院报销比例集合
     */
    public List<HospitalRatioLevel3> selectHospitalRatioLevel3List(HospitalRatioLevel3 hospitalRatioLevel3);

    /**
     * 新增三级医院报销比例
     *
     * @param hospitalRatioLevel3 三级医院报销比例
     * @return 结果
     */
    @AutoFill(value = OperationType.INSERT)
    public int insertHospitalRatioLevel3(HospitalRatioLevel3 hospitalRatioLevel3);

    /**
     * 修改三级医院报销比例
     *
     * @param hospitalRatioLevel3 三级医院报销比例
     * @return 结果
     */
    @AutoFill(value = OperationType.UPDATE)
    public int updateHospitalRatioLevel3(HospitalRatioLevel3 hospitalRatioLevel3);

    /**
     * 删除三级医院报销比例
     *
     * @param id 三级医院报销比例主键
     * @return 结果
     */
    public int deleteHospitalRatioLevel3ById(Long id);

    /**
     * 批量删除三级医院报销比例
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHospitalRatioLevel3ByIds(Long[] ids);
}
