package com.health.system.service.impl;

import java.util.List;
import com.health.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.health.system.mapper.MedicalServiceMapper;
import com.health.system.domain.MedicalService;
import com.health.system.service.IMedicalServiceService;

/**
 * 医疗服务项目Service业务层处理
 * 
 *  
 * @date 2025-07-09
 */
@Service
public class MedicalServiceServiceImpl implements IMedicalServiceService 
{
    @Autowired
    private MedicalServiceMapper medicalServiceMapper;

    /**
     * 查询医疗服务项目
     * 
     * @param id 医疗服务项目主键
     * @return 医疗服务项目
     */
    @Override
    public MedicalService selectMedicalServiceById(Long id)
    {
        return medicalServiceMapper.selectMedicalServiceById(id);
    }

    /**
     * 查询医疗服务项目列表
     * 
     * @param medicalService 医疗服务项目
     * @return 医疗服务项目
     */
    @Override
    public List<MedicalService> selectMedicalServiceList(MedicalService medicalService)
    {
        return medicalServiceMapper.selectMedicalServiceList(medicalService);
    }

    /**
     * 新增医疗服务项目
     * 
     * @param medicalService 医疗服务项目
     * @return 结果
     */
    @Override
    public int insertMedicalService(MedicalService medicalService)
    {
        medicalService.setCreateTime(DateUtils.getNowDate());
        return medicalServiceMapper.insertMedicalService(medicalService);
    }

    /**
     * 修改医疗服务项目
     * 
     * @param medicalService 医疗服务项目
     * @return 结果
     */
    @Override
    public int updateMedicalService(MedicalService medicalService)
    {
        medicalService.setUpdateTime(DateUtils.getNowDate());
        return medicalServiceMapper.updateMedicalService(medicalService);
    }

    /**
     * 批量删除医疗服务项目
     * 
     * @param ids 需要删除的医疗服务项目主键
     * @return 结果
     */
    @Override
    public int deleteMedicalServiceByIds(Long[] ids)
    {
        return medicalServiceMapper.deleteMedicalServiceByIds(ids);
    }

    /**
     * 删除医疗服务项目信息
     * 
     * @param id 医疗服务项目主键
     * @return 结果
     */
    @Override
    public int deleteMedicalServiceById(Long id)
    {
        return medicalServiceMapper.deleteMedicalServiceById(id);
    }

    @Override
    public int batchInsertMedicalService(List<MedicalService> serviceList) {
        return medicalServiceMapper.batchInsertMedicalService(serviceList);
    }
}
