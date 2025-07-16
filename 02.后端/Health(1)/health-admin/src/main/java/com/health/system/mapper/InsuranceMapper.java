package com.health.system.mapper;

import java.util.List;

import com.health.common.enums.OperationType;
import com.health.system.annotation.AutoFill;
import com.health.system.domain.Insurance;

/**
 * 药品报销比例Mapper接口
 *
 *  
 * @date 2025-07-09
 */
public interface InsuranceMapper
{
    /**
     * 查询药品报销比例
     *
     * @param id 药品报销比例主键
     * @return 药品报销比例
     */
    public Insurance selectInsuranceById(Long id);

    /**
     * 查询药品报销比例列表
     *
     * @param insurance 药品报销比例
     * @return 药品报销比例集合
     */
    public List<Insurance> selectInsuranceList(Insurance insurance);

    /**
     * 新增药品报销比例
     *
     * @param insurance 药品报销比例
     * @return 结果
     */
    @AutoFill(value = OperationType.INSERT)
    public int insertInsurance(Insurance insurance);

    /**
     * 修改药品报销比例
     *
     * @param insurance 药品报销比例
     * @return 结果
     */
    @AutoFill(value = OperationType.UPDATE)
    public int updateInsurance(Insurance insurance);

    /**
     * 删除药品报销比例
     *
     * @param id 药品报销比例主键
     * @return 结果
     */
    public int deleteInsuranceById(Long id);

    /**
     * 批量删除药品报销比例
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInsuranceByIds(Long[] ids);
}
