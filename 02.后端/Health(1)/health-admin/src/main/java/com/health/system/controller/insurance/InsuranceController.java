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
import com.health.system.domain.Insurance;
import com.health.system.service.IInsuranceService;
import com.health.common.utils.poi.ExcelUtil;
import com.health.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 药品报销比例Controller
 *
 *  
 * @date 2025-07-09
 */
@Api(tags = "医保报销比例接口")
@RestController
@RequestMapping("/system/insurance")
public class InsuranceController extends BaseController
{
    @Autowired
    private IInsuranceService insuranceService;

    /**
     * 查询药品报销比例列表
     */
    @ApiOperation("查询药品报销比例列表（无分页）")
    @GetMapping("/listAt")
    public TableDataInfo listAt(Insurance insurance)
    {
        startPage();
        List<Insurance> list = insuranceService.selectInsuranceList(insurance);
        return getDataTable(list);
    }

    /**
     * 查询药品报销比例列表
     */
    @ApiOperation("查询药品报销比例列表（分页）")
    @PreAuthorize("@ss.hasPermi('system:insurance:list')")
    @GetMapping("/list")
    public TableDataInfo list(Insurance insurance)
    {
        startPage();
        List<Insurance> list = insuranceService.selectInsuranceList(insurance);
        return getDataTable(list);
    }

    /**
     * 导出药品报销比例列表
     */
    @ApiOperation("导出药品报销比例列表")
    @PreAuthorize("@ss.hasPermi('system:insurance:export')")
    @Log(title = "药品报销比例", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Insurance insurance)
    {
        List<Insurance> list = insuranceService.selectInsuranceList(insurance);
        ExcelUtil<Insurance> util = new ExcelUtil<Insurance>(Insurance.class);
        util.exportExcel(response, list, "药品报销比例数据");
    }

    /**
     * 获取药品报销比例详细信息
     */
    @ApiOperation("获取药品报销比例详细信息")
    @PreAuthorize("@ss.hasPermi('system:insurance:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(insuranceService.selectInsuranceById(id));
    }

    /**
     * 新增药品报销比例
     */
    @ApiOperation("新增药品报销比例")
    @PreAuthorize("@ss.hasPermi('system:insurance:add')")
    @Log(title = "药品报销比例", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Insurance insurance)
    {
        return toAjax(insuranceService.insertInsurance(insurance));
    }

    /**
     * 修改药品报销比例
     */
    @ApiOperation("修改药品报销比例")
    @PreAuthorize("@ss.hasPermi('system:insurance:edit')")
    @Log(title = "药品报销比例", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Insurance insurance)
    {
        return toAjax(insuranceService.updateInsurance(insurance));
    }

    /**
     * 删除药品报销比例
     */
    @ApiOperation("删除药品报销比例")
    @PreAuthorize("@ss.hasPermi('system:insurance:remove')")
    @Log(title = "药品报销比例", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(insuranceService.deleteInsuranceByIds(ids));
    }
}
