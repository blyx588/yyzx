package com.health.system.service.impl;

import com.health.system.domain.DoctorPrimaryDiagnosis;
import com.health.system.mapper.DoctorPrimaryDiagnosisMapper;
import com.health.system.service.IDoctorPrimaryDiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorPrimaryDiagnosisServiceImpl implements IDoctorPrimaryDiagnosisService {
    @Autowired
    private DoctorPrimaryDiagnosisMapper doctorPrimaryDiagnosisMapper;

    @Override
    public DoctorPrimaryDiagnosis selectDoctorPrimaryDiagnosisById(Long id) {
        return doctorPrimaryDiagnosisMapper.selectDoctorPrimaryDiagnosisById(id);
    }

    @Override
    public List<DoctorPrimaryDiagnosis> selectDoctorPrimaryDiagnosisList(DoctorPrimaryDiagnosis doctorPrimaryDiagnosis) {
        return doctorPrimaryDiagnosisMapper.selectDoctorPrimaryDiagnosisList(doctorPrimaryDiagnosis);
    }

    @Override
    public int insertDoctorPrimaryDiagnosis(DoctorPrimaryDiagnosis doctorPrimaryDiagnosis) {
        return doctorPrimaryDiagnosisMapper.insertDoctorPrimaryDiagnosis(doctorPrimaryDiagnosis);
    }

    @Override
    public int updateDoctorPrimaryDiagnosis(DoctorPrimaryDiagnosis doctorPrimaryDiagnosis) {
        return doctorPrimaryDiagnosisMapper.updateDoctorPrimaryDiagnosis(doctorPrimaryDiagnosis);
    }

    @Override
    public int deleteDoctorPrimaryDiagnosisByIds(Long[] ids) {
        return doctorPrimaryDiagnosisMapper.deleteDoctorPrimaryDiagnosisByIds(ids);
    }

    @Override
    public int deleteDoctorPrimaryDiagnosisById(Long id) {
        return doctorPrimaryDiagnosisMapper.deleteDoctorPrimaryDiagnosisById(id);
    }

    @Override
    public List<DoctorPrimaryDiagnosis> selectByRegisterId(Long registerId) {
        return doctorPrimaryDiagnosisMapper.selectByRegisterId(registerId);
    }

    @Override
    public int batchInsertPrimaryDiagnosis(List<DoctorPrimaryDiagnosis> list) {
        return doctorPrimaryDiagnosisMapper.batchInsertPrimaryDiagnosis(list);
    }
}