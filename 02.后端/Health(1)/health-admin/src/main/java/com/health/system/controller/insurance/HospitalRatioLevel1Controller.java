package com.health.system.controller.insurance;

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
import com.health.system.domain.HospitalRatioLevel1;
import com.health.system.service.IHospitalRatioLevel1Service;
import com.health.common.utils.poi.ExcelUtil;
import com.health.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 一级医院报销比例Controller
 *
 *  
 * @date 2025-07-09
 */
@Api(tags = "一级医院报销比例接口")
@RestController
@RequestMapping("/system/level1")
public class HospitalRatioLevel1Controller extends BaseController
{
    @Autowired
    private IHospitalRatioLevel1Service hospitalRatioLevel1Service;

    /**
     * 查询一级医院报销比例列表
     */
    @ApiOperation("查询一级医院报销比例列表（无分页）")
    @GetMapping("/listAt")
    public TableDataInfo listAt(HospitalRatioLevel1 hospitalRatioLevel1)
    {
        List<HospitalRatioLevel1> list = hospitalRatioLevel1Service.selectHospitalRatioLevel1List(hospitalRatioLevel1);
        return getDataTable(list);
    }

    /**
     * 查询一级医院报销比例列表
     */
    @ApiOperation("查询一级医院报销比例列表（分页）")
    @PreAuthorize("@ss.hasPermi('system:level1:list')")
    @GetMapping("/list")
    public TableDataInfo list(HospitalRatioLevel1 hospitalRatioLevel1)
    {
        startPage();
        List<HospitalRatioLevel1> list = hospitalRatioLevel1Service.selectHospitalRatioLevel1List(hospitalRatioLevel1);
        return getDataTable(list);
    }

    /**
     * 导出一级医院报销比例列表
     */
    @ApiOperation("导出一级医院报销比例列表")
    @PreAuthorize("@ss.hasPermi('system:level1:export')")
    @Log(title = "一级医院报销比例", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HospitalRatioLevel1 hospitalRatioLevel1)
    {
        List<HospitalRatioLevel1> list = hospitalRatioLevel1Service.selectHospitalRatioLevel1List(hospitalRatioLevel1);
        ExcelUtil<HospitalRatioLevel1> util = new ExcelUtil<HospitalRatioLevel1>(HospitalRatioLevel1.class);
        util.exportExcel(response, list, "一级医院报销比例数据");
    }

    /**
     * 获取一级医院报销比例详细信息
     */
    @ApiOperation("获取一级医院报销比例详细信息")
    @PreAuthorize("@ss.hasPermi('system:level1:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hospitalRatioLevel1Service.selectHospitalRatioLevel1ById(id));
    }

    /**
     * 新增一级医院报销比例
     */
    @ApiOperation("新增一级医院报销比例")
    @PreAuthorize("@ss.hasPermi('system:level1:add')")
    @Log(title = "一级医院报销比例", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HospitalRatioLevel1 hospitalRatioLevel1)
    {
        return toAjax(hospitalRatioLevel1Service.insertHospitalRatioLevel1(hospitalRatioLevel1));
    }

    /**
     * 修改一级医院报销比例
     */
    @ApiOperation("修改一级医院报销比例")
    @PreAuthorize("@ss.hasPermi('system:level1:edit')")
    @Log(title = "一级医院报销比例", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HospitalRatioLevel1 hospitalRatioLevel1)
    {
        return toAjax(hospitalRatioLevel1Service.updateHospitalRatioLevel1(hospitalRatioLevel1));
    }

    /**
     * 删除一级医院报销比例
     */
    @ApiOperation("删除一级医院报销比例")
    @PreAuthorize("@ss.hasPermi('system:level1:remove')")
    @Log(title = "一级医院报销比例", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hospitalRatioLevel1Service.deleteHospitalRatioLevel1ByIds(ids));
    }
}
