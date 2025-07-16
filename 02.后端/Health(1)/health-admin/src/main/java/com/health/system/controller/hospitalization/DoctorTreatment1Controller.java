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
import com.health.system.domain.DoctorTreatment1;
import com.health.system.service.IDoctorTreatment1Service;
import com.health.common.utils.poi.ExcelUtil;
import com.health.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 诊疗项目医嘱Controller
 *
 *  
 * @date 2025-07-10
 */
@Api(tags = "诊疗项目接口")
@RestController
@RequestMapping("/system/treatment1")
public class DoctorTreatment1Controller extends BaseController
{
    @Autowired
    private IDoctorTreatment1Service doctorTreatment1Service;

    /**
     * 查询诊疗项目医嘱列表
     */
    @ApiOperation("查询诊疗项目医嘱列表（无分页）")
    @GetMapping("/listAt")
    public TableDataInfo listAt(DoctorTreatment1 doctorTreatment1)
    {
        List<DoctorTreatment1> list = doctorTreatment1Service.selectDoctorTreatment1List(doctorTreatment1);
        return getDataTable(list);
    }

    /**
     * 查询诊疗项目医嘱列表
     */
    @ApiOperation("查询诊疗项目医嘱列表（分页）")
    @PreAuthorize("@ss.hasPermi('system:treatment1:list')")
    @GetMapping("/list")
    public TableDataInfo list(DoctorTreatment1 doctorTreatment1)
    {
        startPage();
        List<DoctorTreatment1> list = doctorTreatment1Service.selectDoctorTreatment1List(doctorTreatment1);
        return getDataTable(list);
    }

    /**
     * 导出诊疗项目医嘱列表
     */
    @ApiOperation("导出诊疗项目医嘱列表")
    @PreAuthorize("@ss.hasPermi('system:treatment1:export')")
    @Log(title = "诊疗项目医嘱", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DoctorTreatment1 doctorTreatment1)
    {
        List<DoctorTreatment1> list = doctorTreatment1Service.selectDoctorTreatment1List(doctorTreatment1);
        ExcelUtil<DoctorTreatment1> util = new ExcelUtil<DoctorTreatment1>(DoctorTreatment1.class);
        util.exportExcel(response, list, "诊疗项目医嘱数据");
    }

    /**
     * 获取诊疗项目医嘱详细信息
     */
    @ApiOperation("获取诊疗项目医嘱详细信息")
    @PreAuthorize("@ss.hasPermi('system:treatment1:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(doctorTreatment1Service.selectDoctorTreatment1ById(id));
    }

    /**
     * 新增诊疗项目医嘱
     */
    @ApiOperation("新增诊疗项目医嘱")
    @PreAuthorize("@ss.hasPermi('system:treatment1:add')")
    @Log(title = "诊疗项目医嘱", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DoctorTreatment1 doctorTreatment1)
    {
        return toAjax(doctorTreatment1Service.insertDoctorTreatment1(doctorTreatment1));
    }

    /**
     * 修改诊疗项目医嘱
     */
    @ApiOperation("修改诊疗项目医嘱")
    @PreAuthorize("@ss.hasPermi('system:treatment1:edit')")
    @Log(title = "诊疗项目医嘱", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DoctorTreatment1 doctorTreatment1)
    {
        return toAjax(doctorTreatment1Service.updateDoctorTreatment1(doctorTreatment1));
    }

    /**
     * 删除诊疗项目医嘱
     */
    @ApiOperation("删除诊疗项目医嘱")
    @PreAuthorize("@ss.hasPermi('system:treatment1:remove')")
    @Log(title = "诊疗项目医嘱", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(doctorTreatment1Service.deleteDoctorTreatment1ByIds(ids));
    }
}
