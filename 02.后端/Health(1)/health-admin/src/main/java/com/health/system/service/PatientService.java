package com.health.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.health.system.domain.Patient;


public interface PatientService extends IService<Patient> {

    /**
     * 创建入院登记
     * @param patient 入院登记信息
     */
    void register(Patient patient);
}
