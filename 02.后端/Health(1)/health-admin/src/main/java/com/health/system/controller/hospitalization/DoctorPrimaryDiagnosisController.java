package com.health.system.controller.hospitalization;

import com.health.common.annotation.Log;
import com.health.common.core.controller.BaseController;
import com.health.common.core.domain.AjaxResult;
import com.health.common.core.page.TableDataInfo;
import com.health.common.enums.BusinessType;
import com.health.system.domain.DoctorPrimaryDiagnosis;
import com.health.system.service.IDoctorPrimaryDiagnosisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 主要诊断Controller
 */
@Api(tags = "主要诊断接口")
@RestController
@RequestMapping("/system/primaryDiagnosis")
public class DoctorPrimaryDiagnosisController extends BaseController {
    @Autowired
    private IDoctorPrimaryDiagnosisService doctorPrimaryDiagnosisService;

    /**
     * 查询主要诊断列表
     */
    @ApiOperation("查询主要诊断列表（无分页）")
    @GetMapping("/listAt")
    public TableDataInfo listAt(DoctorPrimaryDiagnosis doctorPrimaryDiagnosis) {
        List<DoctorPrimaryDiagnosis> list = doctorPrimaryDiagnosisService.selectDoctorPrimaryDiagnosisList(doctorPrimaryDiagnosis);
        return getDataTable(list);
    }

    /**
     * 查询主要诊断列表
     */
    @ApiOperation("查询主要诊断列表（分页）")
    @PreAuthorize("@ss.hasPermi('system:primaryDiagnosis:list')")
    @GetMapping("/list")
    public TableDataInfo list(DoctorPrimaryDiagnosis doctorPrimaryDiagnosis) {
        startPage();
        List<DoctorPrimaryDiagnosis> list = doctorPrimaryDiagnosisService.selectDoctorPrimaryDiagnosisList(doctorPrimaryDiagnosis);
        return getDataTable(list);
    }

    /**
     * 获取主要诊断详细信息
     */
    @ApiOperation("获取主要诊断详细信息")
    @PreAuthorize("@ss.hasPermi('system:primaryDiagnosis:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(doctorPrimaryDiagnosisService.selectDoctorPrimaryDiagnosisById(id));
    }

    /**
     * 新增主要诊断
     */
    @ApiOperation("新增主要诊断")
    @PreAuthorize("@ss.hasPermi('system:primaryDiagnosis:add')")
    @Log(title = "主要诊断", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DoctorPrimaryDiagnosis doctorPrimaryDiagnosis) {
        return toAjax(doctorPrimaryDiagnosisService.insertDoctorPrimaryDiagnosis(doctorPrimaryDiagnosis));
    }

    /**
     * 修改主要诊断
     */
    @ApiOperation("修改主要诊断")
    @PreAuthorize("@ss.hasPermi('system:primaryDiagnosis:edit')")
    @Log(title = "主要诊断", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DoctorPrimaryDiagnosis doctorPrimaryDiagnosis) {
        return toAjax(doctorPrimaryDiagnosisService.updateDoctorPrimaryDiagnosis(doctorPrimaryDiagnosis));
    }

    /**
     * 删除主要诊断
     */
    @ApiOperation("删除主要诊断")
    @PreAuthorize("@ss.hasPermi('system:primaryDiagnosis:remove')")
    @Log(title = "主要诊断", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(doctorPrimaryDiagnosisService.deleteDoctorPrimaryDiagnosisByIds(ids));
    }

    /**
     * 根据登记ID查询主要诊断
     */
    @ApiOperation("根据登记ID查询主要诊断")
    @GetMapping("/byRegister/{registerId}")
    public AjaxResult getByRegisterId(@PathVariable Long registerId) {
        return success(doctorPrimaryDiagnosisService.selectByRegisterId(registerId));
    }
}
