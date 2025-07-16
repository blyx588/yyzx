package com.health.system.mapper;

import java.util.List;

import com.health.common.enums.OperationType;
import com.health.system.annotation.AutoFill;
import com.health.system.domain.HospitalRatioLevel2;

/**
 * 二级医院报销比例Mapper接口
 *
 *  
 * @date 2025-07-09
 */
public interface HospitalRatioLevel2Mapper
{
    /**
     * 查询二级医院报销比例
     *
     * @param id 二级医院报销比例主键
     * @return 二级医院报销比例
     */
    public HospitalRatioLevel2 selectHospitalRatioLevel2ById(Long id);

    /**
     * 查询二级医院报销比例列表
     *
     * @param hospitalRatioLevel2 二级医院报销比例
     * @return 二级医院报销比例集合
     */
    public List<HospitalRatioLevel2> selectHospitalRatioLevel2List(HospitalRatioLevel2 hospitalRatioLevel2);

    /**
     * 新增二级医院报销比例
     *
     * @param hospitalRatioLevel2 二级医院报销比例
     * @return 结果
     */
    @AutoFill(value = OperationType.INSERT)
    public int insertHospitalRatioLevel2(HospitalRatioLevel2 hospitalRatioLevel2);

    /**
     * 修改二级医院报销比例
     *
     * @param hospitalRatioLevel2 二级医院报销比例
     * @return 结果
     */
    @AutoFill(value = OperationType.UPDATE)
    public int updateHospitalRatioLevel2(HospitalRatioLevel2 hospitalRatioLevel2);

    /**
     * 删除二级医院报销比例
     *
     * @param id 二级医院报销比例主键
     * @return 结果
     */
    public int deleteHospitalRatioLevel2ById(Long id);

    /**
     * 批量删除二级医院报销比例
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHospitalRatioLevel2ByIds(Long[] ids);
}
