package com.health.system.service.impl;

import java.util.List;
import com.health.common.utils.DateUtils;
import com.health.system.domain.MedicalServiceItem;
import com.health.system.mapper.MedicalServiceItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.health.system.mapper.DoctorTreatment1Mapper;
import com.health.system.domain.DoctorTreatment1;
import com.health.system.service.IDoctorTreatment1Service;

/**
 * 诊疗项目医嘱Service业务层处理
 *
 *  
 * @date 2025-07-10
 */
@Service
public class DoctorTreatment1ServiceImpl implements IDoctorTreatment1Service
{
    @Autowired
    private DoctorTreatment1Mapper doctorTreatment1Mapper;
    @Autowired
    private MedicalServiceItemMapper medicalServiceItemMapper;
    /**
     * 查询诊疗项目医嘱
     *
     * @param id 诊疗项目医嘱主键
     * @return 诊疗项目医嘱
     */
    @Override
    public DoctorTreatment1 selectDoctorTreatment1ById(Long id)
    {
        return doctorTreatment1Mapper.selectDoctorTreatment1ById(id);
    }

    /**
     * 查询诊疗项目医嘱列表
     *
     * @param doctorTreatment1 诊疗项目医嘱
     * @return 诊疗项目医嘱
     */
    @Override
    public List<DoctorTreatment1> selectDoctorTreatment1List(DoctorTreatment1 doctorTreatment1)
    {
        return doctorTreatment1Mapper.selectDoctorTreatment1List(doctorTreatment1);
    }

    @Override
    public List<DoctorTreatment1> selectDoctorTreatment1ListByRegisterId(Long registerId) {
        return doctorTreatment1Mapper.selectDoctorTreatment1ListByRegisterId(registerId);
    }

    /**
     * 新增诊疗项目医嘱
     *
     * @param doctorTreatment1 诊疗项目医嘱
     * @return 结果
     */
    @Override
    public int insertDoctorTreatment1(DoctorTreatment1 doctorTreatment1)
    {
        // 获取诊疗项目信息
        MedicalServiceItem medicalServiceItem = medicalServiceItemMapper.selectMedicalServiceItemById(doctorTreatment1.getItemId());
        // 填充诊疗项目信息
        doctorTreatment1.setTreatmentName(medicalServiceItem.getItemName());
        doctorTreatment1.setItemCode(medicalServiceItem.getItemCode());
        doctorTreatment1.setExclusionContent(medicalServiceItem.getExclusionContent());
        doctorTreatment1.setPrice(medicalServiceItem.getPrice());
        doctorTreatment1.setUnit(medicalServiceItem.getUnit());
        // 新增诊疗项目医嘱
        return doctorTreatment1Mapper.insertDoctorTreatment1(doctorTreatment1);
    }

    /**
     * 修改诊疗项目医嘱
     *
     * @param doctorTreatment1 诊疗项目医嘱
     * @return 结果
     */
    @Override
    public int updateDoctorTreatment1(DoctorTreatment1 doctorTreatment1)
    {
        doctorTreatment1.setUpdateTime(DateUtils.getNowDate());
        return doctorTreatment1Mapper.updateDoctorTreatment1(doctorTreatment1);
    }

    /**
     * 批量删除诊疗项目医嘱
     *
     * @param ids 需要删除的诊疗项目医嘱主键
     * @return 结果
     */
    @Override
    public int deleteDoctorTreatment1ByIds(Long[] ids)
    {
        return doctorTreatment1Mapper.deleteDoctorTreatment1ByIds(ids);
    }

    /**
     * 删除诊疗项目医嘱信息
     *
     * @param id 诊疗项目医嘱主键
     * @return 结果
     */
    @Override
    public int deleteDoctorTreatment1ById(Long id)
    {
        return doctorTreatment1Mapper.deleteDoctorTreatment1ById(id);
    }
}
