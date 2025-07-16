package com.health.system.service;

import java.util.List;
import com.health.system.domain.MedicalInsuranceDrug;

/**
 * 医保药品信息Service接口
 * 
 *  
 * @date 2025-07-09
 */
public interface IMedicalInsuranceDrugService 
{
    /**
     * 查询医保药品信息
     * 
     * @param id 医保药品信息主键
     * @return 医保药品信息
     */
    public MedicalInsuranceDrug selectMedicalInsuranceDrugById(Long id);

    /**
     * 查询医保药品信息列表
     * 
     * @param medicalInsuranceDrug 医保药品信息
     * @return 医保药品信息集合
     */
    public List<MedicalInsuranceDrug> selectMedicalInsuranceDrugList(MedicalInsuranceDrug medicalInsuranceDrug);

    /**
     * 新增医保药品信息
     * 
     * @param medicalInsuranceDrug 医保药品信息
     * @return 结果
     */
    public int insertMedicalInsuranceDrug(MedicalInsuranceDrug medicalInsuranceDrug);

    /**
     * 修改医保药品信息
     * 
     * @param medicalInsuranceDrug 医保药品信息
     * @return 结果
     */
    public int updateMedicalInsuranceDrug(MedicalInsuranceDrug medicalInsuranceDrug);

    /**
     * 批量删除医保药品信息
     * 
     * @param ids 需要删除的医保药品信息主键集合
     * @return 结果
     */
    public int deleteMedicalInsuranceDrugByIds(Long[] ids);

    /**
     * 删除医保药品信息信息
     * 
     * @param id 医保药品信息主键
     * @return 结果
     */
    public int deleteMedicalInsuranceDrugById(Long id);

    /**
     * 批量导入医保药品信息
     * @param drugList 药品列表
     * @return 插入条数
     */
    int batchInsertMedicalInsuranceDrug(List<MedicalInsuranceDrug> drugList);
}
