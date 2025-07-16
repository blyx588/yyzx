package com.health.system.mapper;

import com.health.system.domain.DoctorPrimaryDiagnosis;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface DoctorPrimaryDiagnosisMapper {
    DoctorPrimaryDiagnosis selectDoctorPrimaryDiagnosisById(Long id);
    List<DoctorPrimaryDiagnosis> selectDoctorPrimaryDiagnosisList(DoctorPrimaryDiagnosis doctorPrimaryDiagnosis);
    int insertDoctorPrimaryDiagnosis(DoctorPrimaryDiagnosis doctorPrimaryDiagnosis);
    int updateDoctorPrimaryDiagnosis(DoctorPrimaryDiagnosis doctorPrimaryDiagnosis);
    int deleteDoctorPrimaryDiagnosisById(Long id);
    int deleteDoctorPrimaryDiagnosisByIds(Long[] ids);
    List<DoctorPrimaryDiagnosis> selectByRegisterId(Long registerId);
    int batchInsertPrimaryDiagnosis(List<DoctorPrimaryDiagnosis> list);
}