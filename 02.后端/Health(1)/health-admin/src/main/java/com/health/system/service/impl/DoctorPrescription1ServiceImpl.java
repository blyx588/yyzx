package com.health.system.service.impl;

import java.util.List;
import com.health.common.utils.DateUtils;
import com.health.system.domain.MedicalInsuranceDrug;
import com.health.system.mapper.MedicalInsuranceDrugMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.health.system.mapper.DoctorPrescription1Mapper;
import com.health.system.domain.DoctorPrescription1;
import com.health.system.service.IDoctorPrescription1Service;

/**
 * 药品处方医嘱Service业务层处理
 *
 *  
 * @date 2025-07-10
 */
@Service
public class DoctorPrescription1ServiceImpl implements IDoctorPrescription1Service
{
    @Autowired
    private DoctorPrescription1Mapper doctorPrescription1Mapper;
    @Autowired
    private MedicalInsuranceDrugMapper medicalInsuranceDrugMapper;

    /**
     * 查询药品处方医嘱
     *
     * @param id 药品处方医嘱主键
     * @return 药品处方医嘱
     */
    @Override
    public DoctorPrescription1 selectDoctorPrescription1ById(Long id)
    {
        return doctorPrescription1Mapper.selectDoctorPrescription1ById(id);
    }

    /**
     * 查询药品处方医嘱列表
     *
     * @param doctorPrescription1 药品处方医嘱
     * @return 药品处方医嘱
     */
    @Override
    public List<DoctorPrescription1> selectDoctorPrescription1List(DoctorPrescription1 doctorPrescription1)
    {
        return doctorPrescription1Mapper.selectDoctorPrescription1List(doctorPrescription1);
    }

    /**
     * 新增药品处方医嘱
     *
     * @param doctorPrescription1 药品处方医嘱
     * @return 结果
     */
    @Override
    public int insertDoctorPrescription1(DoctorPrescription1 doctorPrescription1)
    {
        // 获取药品信息
        MedicalInsuranceDrug medicalInsuranceDrug = medicalInsuranceDrugMapper.selectMedicalInsuranceDrugById(doctorPrescription1.getDrugId());
        // 填充药品信息
        doctorPrescription1.setDrugName(medicalInsuranceDrug.getDrugNameCn());
        doctorPrescription1.setPrice(medicalInsuranceDrug.getPaymentStandard());
        doctorPrescription1.setUnit(medicalInsuranceDrug.getUnit());
        doctorPrescription1.setSpecification(medicalInsuranceDrug.getSpecification());
        doctorPrescription1.setManufacturer(medicalInsuranceDrug.getManufacturer());
        doctorPrescription1.setCategory(medicalInsuranceDrug.getCategory());
        // 新增药品处方医嘱
        return doctorPrescription1Mapper.insertDoctorPrescription1(doctorPrescription1);
    }

    /**
     * 修改药品处方医嘱
     *
     * @param doctorPrescription1 药品处方医嘱
     * @return 结果
     */
    @Override
    public int updateDoctorPrescription1(DoctorPrescription1 doctorPrescription1)
    {
        doctorPrescription1.setUpdateTime(DateUtils.getNowDate());
        return doctorPrescription1Mapper.updateDoctorPrescription1(doctorPrescription1);
    }

    /**
     * 批量删除药品处方医嘱
     *
     * @param ids 需要删除的药品处方医嘱主键
     * @return 结果
     */
    @Override
    public int deleteDoctorPrescription1ByIds(Long[] ids)
    {
        return doctorPrescription1Mapper.deleteDoctorPrescription1ByIds(ids);
    }

    /**
     * 删除药品处方医嘱信息
     *
     * @param id 药品处方医嘱主键
     * @return 结果
     */
    @Override
    public int deleteDoctorPrescription1ById(Long id)
    {
        return doctorPrescription1Mapper.deleteDoctorPrescription1ById(id);
    }

    @Override
    public List<DoctorPrescription1> selectDoctorPrescription1ListByRegisterId(Long registerId) {
        return doctorPrescription1Mapper.selectDoctorPrescription1ListByRegisterId(registerId);
    }
}
