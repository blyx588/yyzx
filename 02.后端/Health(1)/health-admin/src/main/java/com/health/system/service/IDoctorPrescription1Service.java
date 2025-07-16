package com.health.system.service;

import java.util.List;
import com.health.system.domain.DoctorPrescription1;

/**
 * 药品处方医嘱Service接口
 * 
 *  
 * @date 2025-07-10
 */
public interface IDoctorPrescription1Service 
{
    /**
     * 查询药品处方医嘱
     * 
     * @param id 药品处方医嘱主键
     * @return 药品处方医嘱
     */
    public DoctorPrescription1 selectDoctorPrescription1ById(Long id);

    /**
     * 查询药品处方医嘱列表
     * 
     * @param doctorPrescription1 药品处方医嘱
     * @return 药品处方医嘱集合
     */
    public List<DoctorPrescription1> selectDoctorPrescription1List(DoctorPrescription1 doctorPrescription1);

    /**
     * 新增药品处方医嘱
     * 
     * @param doctorPrescription1 药品处方医嘱
     * @return 结果
     */
    public int insertDoctorPrescription1(DoctorPrescription1 doctorPrescription1);

    /**
     * 修改药品处方医嘱
     * 
     * @param doctorPrescription1 药品处方医嘱
     * @return 结果
     */
    public int updateDoctorPrescription1(DoctorPrescription1 doctorPrescription1);

    /**
     * 批量删除药品处方医嘱
     * 
     * @param ids 需要删除的药品处方医嘱主键集合
     * @return 结果
     */
    public int deleteDoctorPrescription1ByIds(Long[] ids);

    /**
     * 删除药品处方医嘱信息
     * 
     * @param id 药品处方医嘱主键
     * @return 结果
     */
    public int deleteDoctorPrescription1ById(Long id);

    /**
     * 根据registerId查询处方单
     */
    List<DoctorPrescription1> selectDoctorPrescription1ListByRegisterId(Long registerId);
}
