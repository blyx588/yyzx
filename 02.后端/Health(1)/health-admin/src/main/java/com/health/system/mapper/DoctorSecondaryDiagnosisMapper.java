package com.health.system.mapper;

import com.health.system.domain.DoctorSecondaryDiagnosis;
import java.util.List;

/**
 * 其他诊断Mapper接口
 */
public interface DoctorSecondaryDiagnosisMapper {
    /**
     * 查询其他诊断
     */
    DoctorSecondaryDiagnosis selectDoctorSecondaryDiagnosisById(Long id);

    /**
     * 查询其他诊断列表
     */
    List<DoctorSecondaryDiagnosis> selectDoctorSecondaryDiagnosisList(DoctorSecondaryDiagnosis doctorSecondaryDiagnosis);

    /**
     * 新增其他诊断
     */
    int insertDoctorSecondaryDiagnosis(DoctorSecondaryDiagnosis doctorSecondaryDiagnosis);

    /**
     * 修改其他诊断
     */
    int updateDoctorSecondaryDiagnosis(DoctorSecondaryDiagnosis doctorSecondaryDiagnosis);

    /**
     * 删除其他诊断
     */
    int deleteDoctorSecondaryDiagnosisById(Long id);

    /**
     * 批量删除其他诊断
     */
    int deleteDoctorSecondaryDiagnosisByIds(Long[] ids);

    /**
     * 根据登记ID查询其他诊断
     */
    List<DoctorSecondaryDiagnosis> selectByRegisterId(Long registerId);
}
