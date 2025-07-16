package com.health.system.mapper;

import java.util.List;

import com.health.common.enums.OperationType;
import com.health.system.annotation.AutoFill;
import com.health.system.domain.DoctorPrescription1;

/**
 * 药品处方医嘱Mapper接口
 *
 *  
 * @date 2025-07-10
 */
public interface DoctorPrescription1Mapper
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
     * 根据registerId查询处方单
     */
    List<DoctorPrescription1> selectDoctorPrescription1ListByRegisterId(Long registerId);

    /**
     * 新增药品处方医嘱
     *
     * @param doctorPrescription1 药品处方医嘱
     * @return 结果
     */
    @AutoFill(value = OperationType.INSERT)
    public int insertDoctorPrescription1(DoctorPrescription1 doctorPrescription1);

    /**
     * 修改药品处方医嘱
     *
     * @param doctorPrescription1 药品处方医嘱
     * @return 结果
     */
    @AutoFill(value = OperationType.UPDATE)
    public int updateDoctorPrescription1(DoctorPrescription1 doctorPrescription1);

    /**
     * 删除药品处方医嘱
     *
     * @param id 药品处方医嘱主键
     * @return 结果
     */
    public int deleteDoctorPrescription1ById(Long id);

    /**
     * 批量删除药品处方医嘱
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDoctorPrescription1ByIds(Long[] ids);
}
