package com.health.system.service.impl;

import com.health.system.domain.DoctorSecondaryDiagnosis;
import com.health.system.mapper.DoctorSecondaryDiagnosisMapper;
import com.health.system.service.IDoctorSecondaryDiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 其他诊断Service实现
 */
@Service
public class DoctorSecondaryDiagnosisServiceImpl implements IDoctorSecondaryDiagnosisService {
    @Autowired
    private DoctorSecondaryDiagnosisMapper doctorSecondaryDiagnosisMapper;

    @Override
    public DoctorSecondaryDiagnosis selectDoctorSecondaryDiagnosisById(Long id) {
        return doctorSecondaryDiagnosisMapper.selectDoctorSecondaryDiagnosisById(id);
    }

    @Override
    public List<DoctorSecondaryDiagnosis> selectDoctorSecondaryDiagnosisList(DoctorSecondaryDiagnosis doctorSecondaryDiagnosis) {
        return doctorSecondaryDiagnosisMapper.selectDoctorSecondaryDiagnosisList(doctorSecondaryDiagnosis);
    }

    @Override
    public int insertDoctorSecondaryDiagnosis(DoctorSecondaryDiagnosis doctorSecondaryDiagnosis) {
        return doctorSecondaryDiagnosisMapper.insertDoctorSecondaryDiagnosis(doctorSecondaryDiagnosis);
    }

    @Override
    public int updateDoctorSecondaryDiagnosis(DoctorSecondaryDiagnosis doctorSecondaryDiagnosis) {
        return doctorSecondaryDiagnosisMapper.updateDoctorSecondaryDiagnosis(doctorSecondaryDiagnosis);
    }

    @Override
    public int deleteDoctorSecondaryDiagnosisByIds(Long[] ids) {
        return doctorSecondaryDiagnosisMapper.deleteDoctorSecondaryDiagnosisByIds(ids);
    }

    @Override
    public List<DoctorSecondaryDiagnosis> selectByRegisterId(Long registerId) {
        return doctorSecondaryDiagnosisMapper.selectByRegisterId(registerId);
    }
}
