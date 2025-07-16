package com.health.system.service;

import java.util.List;
import com.health.system.domain.Insurance;

/**
 * 药品报销比例Service接口
 * 
 *  
 * @date 2025-07-09
 */
public interface IInsuranceService 
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
    public int insertInsurance(Insurance insurance);

    /**
     * 修改药品报销比例
     * 
     * @param insurance 药品报销比例
     * @return 结果
     */
    public int updateInsurance(Insurance insurance);

    /**
     * 批量删除药品报销比例
     * 
     * @param ids 需要删除的药品报销比例主键集合
     * @return 结果
     */
    public int deleteInsuranceByIds(Long[] ids);

    /**
     * 删除药品报销比例信息
     * 
     * @param id 药品报销比例主键
     * @return 结果
     */
    public int deleteInsuranceById(Long id);
}
