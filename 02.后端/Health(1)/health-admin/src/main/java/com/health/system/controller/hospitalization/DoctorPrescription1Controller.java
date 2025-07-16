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
import com.health.system.domain.DoctorPrescription1;
import com.health.system.service.IDoctorPrescription1Service;
import com.health.common.utils.poi.ExcelUtil;
import com.health.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 药品处方医嘱Controller
 *
 *  
 * @date 2025-07-10
 */
@Api(tags = "药品费用接口")
@RestController
@RequestMapping("/system/prescription1")
public class DoctorPrescription1Controller extends BaseController
{
    @Autowired
    private IDoctorPrescription1Service doctorPrescription1Service;

    /**
     * 查询药品处方医嘱列表
     */
    @ApiOperation("查询药品处方医嘱列表（无分页）")
    @GetMapping("/listAt")
    public TableDataInfo listAt(DoctorPrescription1 doctorPrescription1)
    {
        List<DoctorPrescription1> list = doctorPrescription1Service.selectDoctorPrescription1List(doctorPrescription1);
        return getDataTable(list);
    }

    /**
     * 查询药品处方医嘱列表
     */
    @ApiOperation("查询药品处方医嘱列表（分页）")
    @PreAuthorize("@ss.hasPermi('system:prescription1:list')")
    @GetMapping("/list")
    public TableDataInfo list(DoctorPrescription1 doctorPrescription1)
    {
        startPage();
        List<DoctorPrescription1> list = doctorPrescription1Service.selectDoctorPrescription1List(doctorPrescription1);
        return getDataTable(list);
    }

    /**
     * 导出药品处方医嘱列表
     */
    @ApiOperation("导出药品处方医嘱列表")
    @PreAuthorize("@ss.hasPermi('system:prescription1:export')")
    @Log(title = "药品处方医嘱", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DoctorPrescription1 doctorPrescription1)
    {
        List<DoctorPrescription1> list = doctorPrescription1Service.selectDoctorPrescription1List(doctorPrescription1);
        ExcelUtil<DoctorPrescription1> util = new ExcelUtil<DoctorPrescription1>(DoctorPrescription1.class);
        util.exportExcel(response, list, "药品处方医嘱数据");
    }

    /**
     * 获取药品处方医嘱详细信息
     */
    @ApiOperation("获取药品处方医嘱详细信息")
    @PreAuthorize("@ss.hasPermi('system:prescription1:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(doctorPrescription1Service.selectDoctorPrescription1ById(id));
    }

    /**
     * 新增药品处方医嘱
     */
    @ApiOperation("新增药品处方医嘱")
    @PreAuthorize("@ss.hasPermi('system:prescription1:add')")
    @Log(title = "药品处方医嘱", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DoctorPrescription1 doctorPrescription1)
    {
        return toAjax(doctorPrescription1Service.insertDoctorPrescription1(doctorPrescription1));
    }

    /**
     * 修改药品处方医嘱
     */
    @ApiOperation("修改药品处方医嘱")
    @PreAuthorize("@ss.hasPermi('system:prescription1:edit')")
    @Log(title = "药品处方医嘱", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DoctorPrescription1 doctorPrescription1)
    {
        return toAjax(doctorPrescription1Service.updateDoctorPrescription1(doctorPrescription1));
    }

    /**
     * 删除药品处方医嘱
     */
    @ApiOperation("删除药品处方医嘱")
    @PreAuthorize("@ss.hasPermi('system:prescription1:remove')")
    @Log(title = "药品处方医嘱", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(doctorPrescription1Service.deleteDoctorPrescription1ByIds(ids));
    }
}
