package com.health.system.service;

import java.util.List;
import com.health.system.domain.DoctorAdmissionDiagnosis;

/**
 * 入院诊断Service接口
 */
public interface IDoctorAdmissionDiagnosisService {
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
    int insertDoctorAdmissionDiagnosis(DoctorAdmissionDiagnosis doctorAdmissionDiagnosis);

    /**
     * 修改入院诊断
     */
    int updateDoctorAdmissionDiagnosis(DoctorAdmissionDiagnosis doctorAdmissionDiagnosis);

    /**
     * 批量删除入院诊断
     */
    int deleteDoctorAdmissionDiagnosisByIds(Long[] ids);

    /**
     * 删除入院诊断信息
     */
    int deleteDoctorAdmissionDiagnosisById(Long id);

    /**
     * 根据登记ID查询入院诊断
     */
    List<DoctorAdmissionDiagnosis> selectByRegisterId(Long registerId);
}
