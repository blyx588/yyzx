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
import com.health.system.domain.DoctorService1;
import com.health.system.service.IDoctorService1Service;
import com.health.common.utils.poi.ExcelUtil;
import com.health.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 诊疗服务医嘱Controller
 *
 *  
 * @date 2025-07-10
 */
@Api(tags = "医疗服务接口")
@RestController
@RequestMapping("/system/service1")
public class DoctorService1Controller extends BaseController
{
    @Autowired
    private IDoctorService1Service doctorService1Service;

    /**
     * 查询诊疗服务医嘱列表
     */
    @ApiOperation("查询诊疗服务医嘱列表（无分页）")
    @GetMapping("/listAt")
    public TableDataInfo listAt(DoctorService1 doctorService1)
    {
        List<DoctorService1> list = doctorService1Service.selectDoctorService1List(doctorService1);
        return getDataTable(list);
    }

    /**
     * 查询诊疗服务医嘱列表
     */
    @ApiOperation("查询诊疗服务医嘱列表（分页）")
    @PreAuthorize("@ss.hasPermi('system:service1:list')")
    @GetMapping("/list")
    public TableDataInfo list(DoctorService1 doctorService1)
    {
        startPage();
        List<DoctorService1> list = doctorService1Service.selectDoctorService1List(doctorService1);
        return getDataTable(list);
    }

    /**
     * 导出诊疗服务医嘱列表
     */
    @ApiOperation("导出诊疗服务医嘱列表")
    @PreAuthorize("@ss.hasPermi('system:service1:export')")
    @Log(title = "诊疗服务医嘱", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DoctorService1 doctorService1)
    {
        List<DoctorService1> list = doctorService1Service.selectDoctorService1List(doctorService1);
        ExcelUtil<DoctorService1> util = new ExcelUtil<DoctorService1>(DoctorService1.class);
        util.exportExcel(response, list, "诊疗服务医嘱数据");
    }

    /**
     * 获取诊疗服务医嘱详细信息
     */
    @ApiOperation("获取诊疗服务医嘱详细信息")
    @PreAuthorize("@ss.hasPermi('system:service1:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(doctorService1Service.selectDoctorService1ById(id));
    }

    /**
     * 新增诊疗服务医嘱
     */
    @ApiOperation("新增诊疗服务医嘱")
    @PreAuthorize("@ss.hasPermi('system:service1:add')")
    @Log(title = "诊疗服务医嘱", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DoctorService1 doctorService1)
    {
        return toAjax(doctorService1Service.insertDoctorService1(doctorService1));
    }

    /**
     * 修改诊疗服务医嘱
     */
    @ApiOperation("修改诊疗服务医嘱")
    @PreAuthorize("@ss.hasPermi('system:service1:edit')")
    @Log(title = "诊疗服务医嘱", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DoctorService1 doctorService1)
    {
        return toAjax(doctorService1Service.updateDoctorService1(doctorService1));
    }

    /**
     * 删除诊疗服务医嘱
     */
    @ApiOperation("删除诊疗服务医嘱")
    @PreAuthorize("@ss.hasPermi('system:service1:remove')")
    @Log(title = "诊疗服务医嘱", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(doctorService1Service.deleteDoctorService1ByIds(ids));
    }
}
