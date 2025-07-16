package com.health.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.health.system.domain.Patient;
import com.health.system.mapper.PatientMapper;
import com.health.system.service.PatientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(rollbackFor = Exception.class)
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements PatientService {

    @Override
    public void register(Patient patient) {
        // 设置默认值
        patient.setRegisterTime(LocalDateTime.now());
        patient.setStatus(1); // 1: 待审核

        // 保存入院登记信息
        this.save(patient);

    }
}
