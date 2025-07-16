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
import com.health.system.domain.HospitalRatioLevel2;
import com.health.system.service.IHospitalRatioLevel2Service;
import com.health.common.utils.poi.ExcelUtil;
import com.health.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 二级医院报销比例Controller
 *
 *  
 * @date 2025-07-09
 */
@Api(tags = "二级医院报销比例接口")
@RestController
@RequestMapping("/system/level2")
public class HospitalRatioLevel2Controller extends BaseController
{
    @Autowired
    private IHospitalRatioLevel2Service hospitalRatioLevel2Service;

    /**
     * 查询二级医院报销比例列表
     */
    @ApiOperation("查询二级医院报销比例列表（无分页）")
    @GetMapping("/listAt")
    public TableDataInfo listAt(HospitalRatioLevel2 hospitalRatioLevel2)
    {
        startPage();
        List<HospitalRatioLevel2> list = hospitalRatioLevel2Service.selectHospitalRatioLevel2List(hospitalRatioLevel2);
        return getDataTable(list);
    }

    /**
     * 查询二级医院报销比例列表
     */
    @ApiOperation("查询二级医院报销比例列表（分页）")
    @PreAuthorize("@ss.hasPermi('system:level2:list')")
    @GetMapping("/list")
    public TableDataInfo list(HospitalRatioLevel2 hospitalRatioLevel2)
    {
        startPage();
        List<HospitalRatioLevel2> list = hospitalRatioLevel2Service.selectHospitalRatioLevel2List(hospitalRatioLevel2);
        return getDataTable(list);
    }

    /**
     * 导出二级医院报销比例列表
     */
    @ApiOperation("导出二级医院报销比例列表")
    @PreAuthorize("@ss.hasPermi('system:level2:export')")
    @Log(title = "二级医院报销比例", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HospitalRatioLevel2 hospitalRatioLevel2)
    {
        List<HospitalRatioLevel2> list = hospitalRatioLevel2Service.selectHospitalRatioLevel2List(hospitalRatioLevel2);
        ExcelUtil<HospitalRatioLevel2> util = new ExcelUtil<HospitalRatioLevel2>(HospitalRatioLevel2.class);
        util.exportExcel(response, list, "二级医院报销比例数据");
    }

    /**
     * 获取二级医院报销比例详细信息
     */
    @ApiOperation("获取二级医院报销比例详细信息")
    @PreAuthorize("@ss.hasPermi('system:level2:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hospitalRatioLevel2Service.selectHospitalRatioLevel2ById(id));
    }

    /**
     * 新增二级医院报销比例
     */
    @ApiOperation("新增二级医院报销比例")
    @PreAuthorize("@ss.hasPermi('system:level2:add')")
    @Log(title = "二级医院报销比例", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HospitalRatioLevel2 hospitalRatioLevel2)
    {
        return toAjax(hospitalRatioLevel2Service.insertHospitalRatioLevel2(hospitalRatioLevel2));
    }

    /**
     * 修改二级医院报销比例
     */
    @ApiOperation("修改二级医院报销比例")
    @PreAuthorize("@ss.hasPermi('system:level2:edit')")
    @Log(title = "二级医院报销比例", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HospitalRatioLevel2 hospitalRatioLevel2)
    {
        return toAjax(hospitalRatioLevel2Service.updateHospitalRatioLevel2(hospitalRatioLevel2));
    }

    /**
     * 删除二级医院报销比例
     */
    @ApiOperation("删除二级医院报销比例")
    @PreAuthorize("@ss.hasPermi('system:level2:remove')")
    @Log(title = "二级医院报销比例", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hospitalRatioLevel2Service.deleteHospitalRatioLevel2ByIds(ids));
    }
}
