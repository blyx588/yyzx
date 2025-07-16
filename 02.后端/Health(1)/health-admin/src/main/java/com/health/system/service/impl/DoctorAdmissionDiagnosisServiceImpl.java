package com.health.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.health.system.mapper.DoctorAdmissionDiagnosisMapper;
import com.health.system.domain.DoctorAdmissionDiagnosis;
import com.health.system.service.IDoctorAdmissionDiagnosisService;

/**
 * 入院诊断Service业务层处理
 */
@Service
public class DoctorAdmissionDiagnosisServiceImpl implements IDoctorAdmissionDiagnosisService {
    @Autowired
    private DoctorAdmissionDiagnosisMapper doctorAdmissionDiagnosisMapper;

    @Override
    public DoctorAdmissionDiagnosis selectDoctorAdmissionDiagnosisById(Long id) {
        return doctorAdmissionDiagnosisMapper.selectDoctorAdmissionDiagnosisById(id);
    }

    @Override
    public List<DoctorAdmissionDiagnosis> selectDoctorAdmissionDiagnosisList(DoctorAdmissionDiagnosis doctorAdmissionDiagnosis) {
        return doctorAdmissionDiagnosisMapper.selectDoctorAdmissionDiagnosisList(doctorAdmissionDiagnosis);
    }

    @Override
    public int insertDoctorAdmissionDiagnosis(DoctorAdmissionDiagnosis doctorAdmissionDiagnosis) {
        return doctorAdmissionDiagnosisMapper.insertDoctorAdmissionDiagnosis(doctorAdmissionDiagnosis);
    }

    @Override
    public int updateDoctorAdmissionDiagnosis(DoctorAdmissionDiagnosis doctorAdmissionDiagnosis) {
        return doctorAdmissionDiagnosisMapper.updateDoctorAdmissionDiagnosis(doctorAdmissionDiagnosis);
    }

    @Override
    public int deleteDoctorAdmissionDiagnosisByIds(Long[] ids) {
        return doctorAdmissionDiagnosisMapper.deleteDoctorAdmissionDiagnosisByIds(ids);
    }

    @Override
    public int deleteDoctorAdmissionDiagnosisById(Long id) {
        return doctorAdmissionDiagnosisMapper.deleteDoctorAdmissionDiagnosisById(id);
    }

    @Override
    public List<DoctorAdmissionDiagnosis> selectByRegisterId(Long registerId) {
        return doctorAdmissionDiagnosisMapper.selectByRegisterId(registerId);
    }
}
