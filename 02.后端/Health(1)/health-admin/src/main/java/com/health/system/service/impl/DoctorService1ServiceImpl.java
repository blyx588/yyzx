package com.health.system.service.impl;

import java.util.List;
import com.health.common.utils.DateUtils;
import com.health.system.domain.MedicalService;
import com.health.system.mapper.MedicalServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.health.system.mapper.DoctorService1Mapper;
import com.health.system.domain.DoctorService1;
import com.health.system.service.IDoctorService1Service;

/**
 * 诊疗服务医嘱Service业务层处理
 *
 *  
 * @date 2025-07-10
 */
@Service
public class DoctorService1ServiceImpl implements IDoctorService1Service
{
    @Autowired
    private DoctorService1Mapper doctorService1Mapper;
    @Autowired
    private MedicalServiceMapper medicalServiceMapper;

    /**
     * 查询诊疗服务医嘱
     *
     * @param id 诊疗服务医嘱主键
     * @return 诊疗服务医嘱
     */
    @Override
    public DoctorService1 selectDoctorService1ById(Long id)
    {
        return doctorService1Mapper.selectDoctorService1ById(id);
    }

    /**
     * 查询诊疗服务医嘱列表
     *
     * @param doctorService1 诊疗服务医嘱
     * @return 诊疗服务医嘱
     */
    @Override
    public List<DoctorService1> selectDoctorService1List(DoctorService1 doctorService1)
    {
        return doctorService1Mapper.selectDoctorService1List(doctorService1);
    }

    /**
     * 新增诊疗服务医嘱
     *
     * @param doctorService1 诊疗服务医嘱
     * @return 结果
     */
    @Override
    public int insertDoctorService1(DoctorService1 doctorService1)
    {
        // 获取服务医疗项目信息
        MedicalService medicalService = medicalServiceMapper.selectMedicalServiceById(doctorService1.getServiceId());
        // 填充服务信息
        doctorService1.setServiceName(medicalService.getItemName());
        doctorService1.setServiceCode(medicalService.getItemCode());
        doctorService1.setExclusionContent(medicalService.getExclusionContent());
        doctorService1.setUnit(medicalService.getUnit());
        doctorService1.setPrice(medicalService.getPrice());
        // 新增诊疗服务医嘱
        return doctorService1Mapper.insertDoctorService1(doctorService1);
    }

    /**
     * 修改诊疗服务医嘱
     *
     * @param doctorService1 诊疗服务医嘱
     * @return 结果
     */
    @Override
    public int updateDoctorService1(DoctorService1 doctorService1)
    {
        doctorService1.setUpdateTime(DateUtils.getNowDate());
        return doctorService1Mapper.updateDoctorService1(doctorService1);
    }

    /**
     * 批量删除诊疗服务医嘱
     *
     * @param ids 需要删除的诊疗服务医嘱主键
     * @return 结果
     */
    @Override
    public int deleteDoctorService1ByIds(Long[] ids)
    {
        return doctorService1Mapper.deleteDoctorService1ByIds(ids);
    }

    /**
     * 删除诊疗服务医嘱信息
     *
     * @param id 诊疗服务医嘱主键
     * @return 结果
     */
    @Override
    public int deleteDoctorService1ById(Long id)
    {
        return doctorService1Mapper.deleteDoctorService1ById(id);
    }

    @Override
    public List<DoctorService1> selectDoctorService1ListByRegisterId(Long registerId) {
        return doctorService1Mapper.selectDoctorService1ListByRegisterId(registerId);
    }
}
