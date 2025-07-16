package com.health.system.service.impl;

import java.util.List;
import com.health.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.health.system.mapper.MedicalInsuranceDrugMapper;
import com.health.system.domain.MedicalInsuranceDrug;
import com.health.system.service.IMedicalInsuranceDrugService;

/**
 * 医保药品信息Service业务层处理
 *
 *  
 * @date 2025-07-09
 */
@Service
public class MedicalInsuranceDrugServiceImpl implements IMedicalInsuranceDrugService
{
    @Autowired
    private MedicalInsuranceDrugMapper medicalInsuranceDrugMapper;

    /**
     * 查询医保药品信息
     *
     * @param id 医保药品信息主键
     * @return 医保药品信息
     */
    @Override
    public MedicalInsuranceDrug selectMedicalInsuranceDrugById(Long id)
    {
        return medicalInsuranceDrugMapper.selectMedicalInsuranceDrugById(id);
    }

    /**
     * 查询医保药品信息列表
     *
     * @param medicalInsuranceDrug 医保药品信息
     * @return 医保药品信息
     */
    @Override
    public List<MedicalInsuranceDrug> selectMedicalInsuranceDrugList(MedicalInsuranceDrug medicalInsuranceDrug)
    {
        return medicalInsuranceDrugMapper.selectMedicalInsuranceDrugList(medicalInsuranceDrug);
    }

    /**
     * 新增医保药品信息
     *
     * @param medicalInsuranceDrug 医保药品信息
     * @return 结果
     */
    @Override
    public int insertMedicalInsuranceDrug(MedicalInsuranceDrug medicalInsuranceDrug)
    {
        medicalInsuranceDrug.setCreateTime(DateUtils.getNowDate());
        return medicalInsuranceDrugMapper.insertMedicalInsuranceDrug(medicalInsuranceDrug);
    }

    /**
     * 修改医保药品信息
     *
     * @param medicalInsuranceDrug 医保药品信息
     * @return 结果
     */
    @Override
    public int updateMedicalInsuranceDrug(MedicalInsuranceDrug medicalInsuranceDrug)
    {
        medicalInsuranceDrug.setUpdateTime(DateUtils.getNowDate());
        return medicalInsuranceDrugMapper.updateMedicalInsuranceDrug(medicalInsuranceDrug);
    }

    /**
     * 批量删除医保药品信息
     *
     * @param ids 需要删除的医保药品信息主键
     * @return 结果
     */
    @Override
    public int deleteMedicalInsuranceDrugByIds(Long[] ids)
    {
        return medicalInsuranceDrugMapper.deleteMedicalInsuranceDrugByIds(ids);
    }

    /**
     * 删除医保药品信息信息
     *
     * @param id 医保药品信息主键
     * @return 结果
     */
    @Override
    public int deleteMedicalInsuranceDrugById(Long id)
    {
        return medicalInsuranceDrugMapper.deleteMedicalInsuranceDrugById(id);
    }

    /**
     * 批量导入医保药品信息
     * @param drugList 药品列表
     * @return 插入条数
     */
    @Override
    public int batchInsertMedicalInsuranceDrug(List<MedicalInsuranceDrug> drugList) {
        if (drugList == null || drugList.isEmpty()) return 0;
        return medicalInsuranceDrugMapper.batchInsertMedicalInsuranceDrug(drugList);
    }
}
