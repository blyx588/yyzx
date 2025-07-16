package com.health.system.mapper;

import java.util.List;
import com.health.system.domain.DoctorAdmissionDiagnosis;
import com.health.common.enums.OperationType;
import com.health.system.annotation.AutoFill;
import org.apache.ibatis.annotations.Param;

/**
 * 入院诊断Mapper接口
 */
public interface DoctorAdmissionDiagnosisMapper {
    /**
     * 查询入院诊断
     */
    DoctorAdmissionDiagnosis selectDoctorAdmissionDiagnosisById(Long id);

    /**
     * 查询入院诊断列表
     */
    List<DoctorAdmissionDiagnosis> selectDoctorAdmissionDiagnosisList(DoctorAdmissionDiagnosis doctorAdmissionDiagnosis);

    /**
     * 新增入院诊断
     */
    @AutoFill(value = OperationType.INSERT)
    int insertDoctorAdmissionDiagnosis(DoctorAdmissionDiagnosis doctorAdmissionDiagnosis);

    /**
     * 修改入院诊断
     */
    @AutoFill(value = OperationType.UPDATE)
    int updateDoctorAdmissionDiagnosis(DoctorAdmissionDiagnosis doctorAdmissionDiagnosis);

    /**
     * 删除入院诊断
     */
    int deleteDoctorAdmissionDiagnosisById(Long id);

    /**
     * 批量删除入院诊断
     */
    int deleteDoctorAdmissionDiagnosisByIds(Long[] ids);

    /**
     * 根据登记ID查询入院诊断
     */
    List<DoctorAdmissionDiagnosis> selectByRegisterId(Long registerId);
}
