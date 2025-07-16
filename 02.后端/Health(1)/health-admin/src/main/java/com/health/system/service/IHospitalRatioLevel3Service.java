package com.health.system.service;

import java.util.List;
import com.health.system.domain.HospitalRatioLevel3;

/**
 * 三级医院报销比例Service接口
 * 
 *  
 * @date 2025-07-09
 */
public interface IHospitalRatioLevel3Service 
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
    public int insertHospitalRatioLevel3(HospitalRatioLevel3 hospitalRatioLevel3);

    /**
     * 修改三级医院报销比例
     * 
     * @param hospitalRatioLevel3 三级医院报销比例
     * @return 结果
     */
    public int updateHospitalRatioLevel3(HospitalRatioLevel3 hospitalRatioLevel3);

    /**
     * 批量删除三级医院报销比例
     * 
     * @param ids 需要删除的三级医院报销比例主键集合
     * @return 结果
     */
    public int deleteHospitalRatioLevel3ByIds(Long[] ids);

    /**
     * 删除三级医院报销比例信息
     * 
     * @param id 三级医院报销比例主键
     * @return 结果
     */
    public int deleteHospitalRatioLevel3ById(Long id);
}
