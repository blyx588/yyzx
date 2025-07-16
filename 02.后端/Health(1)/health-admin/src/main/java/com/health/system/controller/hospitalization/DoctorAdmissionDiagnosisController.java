package com.health.system.controller.hospitalization;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.health.common.annotation.Log;
import com.health.common.core.controller.BaseController;
import com.health.common.core.domain.AjaxResult;
import com.health.common.enums.BusinessType;
import com.health.system.domain.DoctorAdmissionDiagnosis;
import com.health.system.service.IDoctorAdmissionDiagnosisService;
import com.health.common.utils.poi.ExcelUtil;
import com.health.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 入院诊断Controller
 */
@Api(tags = "入院诊断接口")
@RestController
@RequestMapping("/system/admissionDiagnosis")
public class DoctorAdmissionDiagnosisController extends BaseController {
    @Autowired
    private IDoctorAdmissionDiagnosisService doctorAdmissionDiagnosisService;

    /**
     * 查询入院诊断列表
     */
    @ApiOperation("查询入院诊断列表（无分页）")
    @GetMapping("/listAt")
    public TableDataInfo listAt(DoctorAdmissionDiagnosis doctorAdmissionDiagnosis) {
        List<DoctorAdmissionDiagnosis> list = doctorAdmissionDiagnosisService.selectDoctorAdmissionDiagnosisList(doctorAdmissionDiagnosis);
        return getDataTable(list);
    }

    /**
     * 查询入院诊断列表
     */
    @ApiOperation("查询入院诊断列表（分页）")
    @PreAuthorize("@ss.hasPermi('system:admissionDiagnosis:list')")
    @GetMapping("/list")
    public TableDataInfo list(DoctorAdmissionDiagnosis doctorAdmissionDiagnosis) {
        startPage();
        List<DoctorAdmissionDiagnosis> list = doctorAdmissionDiagnosisService.selectDoctorAdmissionDiagnosisList(doctorAdmissionDiagnosis);
        return getDataTable(list);
    }

    /**
     * 获取入院诊断详细信息
     */
    @ApiOperation("获取入院诊断详细信息")
    @PreAuthorize("@ss.hasPermi('system:admissionDiagnosis:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(doctorAdmissionDiagnosisService.selectDoctorAdmissionDiagnosisById(id));
    }

    /**
     * 新增入院诊断
     */
    @ApiOperation("新增入院诊断")
    @PreAuthorize("@ss.hasPermi('system:admissionDiagnosis:add')")
    @Log(title = "入院诊断", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DoctorAdmissionDiagnosis doctorAdmissionDiagnosis) {
        return toAjax(doctorAdmissionDiagnosisService.insertDoctorAdmissionDiagnosis(doctorAdmissionDiagnosis));
    }

    /**
     * 修改入院诊断
     */
    @ApiOperation("修改入院诊断")
    @PreAuthorize("@ss.hasPermi('system:admissionDiagnosis:edit')")
    @Log(title = "入院诊断", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DoctorAdmissionDiagnosis doctorAdmissionDiagnosis) {
        return toAjax(doctorAdmissionDiagnosisService.updateDoctorAdmissionDiagnosis(doctorAdmissionDiagnosis));
    }

    /**
     * 删除入院诊断
     */
    @ApiOperation("删除入院诊断")
    @PreAuthorize("@ss.hasPermi('system:admissionDiagnosis:remove')")
    @Log(title = "入院诊断", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(doctorAdmissionDiagnosisService.deleteDoctorAdmissionDiagnosisByIds(ids));
    }

    /**
     * 根据登记ID查询入院诊断
     */
    @ApiOperation("根据登记ID查询入院诊断")
    @GetMapping("/byRegister/{registerId}")
    public AjaxResult getByRegisterId(@PathVariable Long registerId) {
        return success(doctorAdmissionDiagnosisService.selectByRegisterId(registerId));
    }
}
