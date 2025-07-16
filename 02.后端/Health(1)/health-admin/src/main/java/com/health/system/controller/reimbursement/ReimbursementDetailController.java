package com.health.system.controller.reimbursement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.health.common.core.domain.AjaxResult;
import com.health.system.service.IInpatientRegisterService;
import com.health.system.service.IDoctorPrescription1Service;
import com.health.system.service.IDoctorTreatment1Service;
import com.health.system.service.IDoctorService1Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Slf4j
@Api(tags = "医保报销明细接口")
@RestController
@RequestMapping("/system/reimbursement/detail")
public class ReimbursementDetailController {

    @Autowired
    private IInpatientRegisterService inpatientRegisterService;
    @Autowired
    private IDoctorPrescription1Service prescriptionService;
    @Autowired
    private IDoctorTreatment1Service treatmentService;
    @Autowired
    private IDoctorService1Service serviceService;

    /**
     * 获取参保人员基本信息
     */
    @ApiOperation("获取参保人员基本信息")
    @GetMapping("/person/{id}")
    public AjaxResult getPersonInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(inpatientRegisterService.selectInpatientRegisterById(id));
    }

    /**
     * 获取药品费用明细
     */
    @ApiOperation("获取药品费用明细")
    @GetMapping("/prescription/{registerId}")
    public AjaxResult getPrescriptionList(@PathVariable("registerId") Long registerId) {
        return AjaxResult.success(prescriptionService.selectDoctorPrescription1ListByRegisterId(registerId));
    }

    /**
     * 获取诊疗项目费用明细
     */
    @ApiOperation("获取诊疗项目费用明细")
    @GetMapping("/treatment/{registerId}")
    public AjaxResult getTreatmentList(@PathVariable("registerId") Long registerId) {
        return AjaxResult.success(treatmentService.selectDoctorTreatment1ListByRegisterId(registerId));
    }

    /**
     * 获取医疗服务费用明细
     */
    @ApiOperation("获取医疗服务费用明细")
    @GetMapping("/service/{registerId}")
    public AjaxResult getServiceList(@PathVariable("registerId") Long registerId) {
        return AjaxResult.success(serviceService.selectDoctorService1ListByRegisterId(registerId));
    }
}
