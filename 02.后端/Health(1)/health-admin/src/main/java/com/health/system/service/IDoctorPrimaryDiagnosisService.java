package com.health.system.service;

import com.health.system.domain.DoctorPrimaryDiagnosis;
import java.util.List;

public interface IDoctorPrimaryDiagnosisService {
    DoctorPrimaryDiagnosis selectDoctorPrimaryDiagnosisById(Long id);
    List<DoctorPrimaryDiagnosis> selectDoctorPrimaryDiagnosisList(DoctorPrimaryDiagnosis doctorPrimaryDiagnosis);
    int insertDoctorPrimaryDiagnosis(DoctorPrimaryDiagnosis doctorPrimaryDiagnosis);
    int updateDoctorPrimaryDiagnosis(DoctorPrimaryDiagnosis doctorPrimaryDiagnosis);
    int deleteDoctorPrimaryDiagnosisByIds(Long[] ids);
    int deleteDoctorPrimaryDiagnosisById(Long id);
    List<DoctorPrimaryDiagnosis> selectByRegisterId(Long registerId);
    int batchInsertPrimaryDiagnosis(List<DoctorPrimaryDiagnosis> list);
}