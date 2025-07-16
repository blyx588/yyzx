package com.health.system.controller.hospitalization;

import com.health.common.annotation.Log;
import com.health.common.core.controller.BaseController;
import com.health.common.core.domain.AjaxResult;
import com.health.common.core.page.TableDataInfo;
import com.health.common.enums.BusinessType;
import com.health.system.domain.DoctorSecondaryDiagnosis;
import com.health.system.service.IDoctorSecondaryDiagnosisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 其他诊断Controller
 */
@Api(tags = "其他诊断接口")
@RestController
@RequestMapping("/system/secondaryDiagnosis")
public class DoctorSecondaryDiagnosisController extends BaseController {
    @Autowired
    private IDoctorSecondaryDiagnosisService doctorSecondaryDiagnosisService;

    /**
     * 查询其他诊断列表
     */
    @ApiOperation("查询其他诊断列表（无分页）")
    @GetMapping("/listAt")
    public TableDataInfo listAt(DoctorSecondaryDiagnosis doctorSecondaryDiagnosis) {
        List<DoctorSecondaryDiagnosis> list = doctorSecondaryDiagnosisService.selectDoctorSecondaryDiagnosisList(doctorSecondaryDiagnosis);
        return getDataTable(list);
    }

    /**
     * 查询其他诊断列表
     */
    @ApiOperation("查询其他诊断列表（分页）")
    @PreAuthorize("@ss.hasPermi('system:secondaryDiagnosis:list')")
    @GetMapping("/list")
    public TableDataInfo list(DoctorSecondaryDiagnosis doctorSecondaryDiagnosis) {
        startPage();
        List<DoctorSecondaryDiagnosis> list = doctorSecondaryDiagnosisService.selectDoctorSecondaryDiagnosisList(doctorSecondaryDiagnosis);
        return getDataTable(list);
    }

    /**
     * 获取其他诊断详细信息
     */
    @ApiOperation("获取其他诊断详细信息")
    @PreAuthorize("@ss.hasPermi('system:secondaryDiagnosis:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(doctorSecondaryDiagnosisService.selectDoctorSecondaryDiagnosisById(id));
    }

    /**
     * 新增其他诊断
     */
    @ApiOperation("新增其他诊断")
    @PreAuthorize("@ss.hasPermi('system:secondaryDiagnosis:add')")
    @Log(title = "其他诊断", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DoctorSecondaryDiagnosis doctorSecondaryDiagnosis) {
        return toAjax(doctorSecondaryDiagnosisService.insertDoctorSecondaryDiagnosis(doctorSecondaryDiagnosis));
    }

    /**
     * 修改其他诊断
     */
    @ApiOperation("修改其他诊断")
    @PreAuthorize("@ss.hasPermi('system:secondaryDiagnosis:edit')")
    @Log(title = "其他诊断", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DoctorSecondaryDiagnosis doctorSecondaryDiagnosis) {
        return toAjax(doctorSecondaryDiagnosisService.updateDoctorSecondaryDiagnosis(doctorSecondaryDiagnosis));
    }

    /**
     * 删除其他诊断
     */
    @ApiOperation("删除其他诊断")
    @PreAuthorize("@ss.hasPermi('system:secondaryDiagnosis:remove')")
    @Log(title = "其他诊断", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(doctorSecondaryDiagnosisService.deleteDoctorSecondaryDiagnosisByIds(ids));
    }

    /**
     * 根据登记ID查询其他诊断
     */
    @ApiOperation("根据登记ID查询其他诊断")
    @GetMapping("/byRegister/{registerId}")
    public AjaxResult getByRegisterId(@PathVariable Long registerId) {
        return success(doctorSecondaryDiagnosisService.selectByRegisterId(registerId));
    }
}
