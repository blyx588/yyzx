package com.health.system.mapper;

import java.util.List;

import com.health.common.enums.OperationType;
import com.health.system.annotation.AutoFill;
import com.health.system.domain.DoctorTreatment1;

/**
 * 诊疗项目医嘱Mapper接口
 *
 *  
 * @date 2025-07-10
 */
public interface DoctorTreatment1Mapper
{
    /**
     * 查询诊疗项目医嘱
     *
     * @param id 诊疗项目医嘱主键
     * @return 诊疗项目医嘱
     */
    public DoctorTreatment1 selectDoctorTreatment1ById(Long id);

    /**
     * 查询诊疗项目医嘱列表
     *
     * @param doctorTreatment1 诊疗项目医嘱
     * @return 诊疗项目医嘱集合
     */
    public List<DoctorTreatment1> selectDoctorTreatment1List(DoctorTreatment1 doctorTreatment1);

    /**
     * 根据registerId查询治疗单
     */
    List<DoctorTreatment1> selectDoctorTreatment1ListByRegisterId(Long registerId);

    /**
     * 新增诊疗项目医嘱
     *
     * @param doctorTreatment1 诊疗项目医嘱
     * @return 结果
     */
    @AutoFill(value = OperationType.INSERT)
    public int insertDoctorTreatment1(DoctorTreatment1 doctorTreatment1);

    /**
     * 修改诊疗项目医嘱
     *
     * @param doctorTreatment1 诊疗项目医嘱
     * @return 结果
     */
    @AutoFill(value = OperationType.UPDATE)
    public int updateDoctorTreatment1(DoctorTreatment1 doctorTreatment1);

    /**
     * 删除诊疗项目医嘱
     *
     * @param id 诊疗项目医嘱主键
     * @return 结果
     */
    public int deleteDoctorTreatment1ById(Long id);

    /**
     * 批量删除诊疗项目医嘱
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDoctorTreatment1ByIds(Long[] ids);
}
