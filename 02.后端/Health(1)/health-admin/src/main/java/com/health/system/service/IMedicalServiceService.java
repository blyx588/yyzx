package com.health.system.service;

import java.util.List;
import com.health.system.domain.MedicalService;

/**
 * 医疗服务项目Service接口
 * 
 *  
 * @date 2025-07-09
 */
public interface IMedicalServiceService 
{
    /**
     * 查询医疗服务项目
     * 
     * @param id 医疗服务项目主键
     * @return 医疗服务项目
     */
    public MedicalService selectMedicalServiceById(Long id);

    /**
     * 查询医疗服务项目列表
     * 
     * @param medicalService 医疗服务项目
     * @return 医疗服务项目集合
     */
    public List<MedicalService> selectMedicalServiceList(MedicalService medicalService);

    /**
     * 新增医疗服务项目
     * 
     * @param medicalService 医疗服务项目
     * @return 结果
     */
    public int insertMedicalService(MedicalService medicalService);

    /**
     * 修改医疗服务项目
     * 
     * @param medicalService 医疗服务项目
     * @return 结果
     */
    public int updateMedicalService(MedicalService medicalService);

    /**
     * 批量删除医疗服务项目
     * 
     * @param ids 需要删除的医疗服务项目主键集合
     * @return 结果
     */
    public int deleteMedicalServiceByIds(Long[] ids);

    /**
     * 删除医疗服务项目信息
     * 
     * @param id 医疗服务项目主键
     * @return 结果
     */
    public int deleteMedicalServiceById(Long id);

    /**
     * 批量插入医疗服务项目
     */
    int batchInsertMedicalService(List<MedicalService> serviceList);
}
