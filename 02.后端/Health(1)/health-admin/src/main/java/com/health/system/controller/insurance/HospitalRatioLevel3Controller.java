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
import com.health.system.domain.HospitalRatioLevel3;
import com.health.system.service.IHospitalRatioLevel3Service;
import com.health.common.utils.poi.ExcelUtil;
import com.health.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 三级医院报销比例Controller
 *
 *  
 * @date 2025-07-09
 */
@Api(tags = "三级医院报销比例接口")
@RestController
@RequestMapping("/system/level3")
public class HospitalRatioLevel3Controller extends BaseController
{
    @Autowired
    private IHospitalRatioLevel3Service hospitalRatioLevel3Service;

    /**
     * 查询三级医院报销比例列表
     */
    @ApiOperation("查询三级医院报销比例列表（无分页）")
    @GetMapping("/listAt")
    public TableDataInfo listAt(HospitalRatioLevel3 hospitalRatioLevel3)
    {
        List<HospitalRatioLevel3> list = hospitalRatioLevel3Service.selectHospitalRatioLevel3List(hospitalRatioLevel3);
        return getDataTable(list);
    }

    /**
     * 查询三级医院报销比例列表
     */
    @ApiOperation("查询三级医院报销比例列表（分页）")
    @PreAuthorize("@ss.hasPermi('system:level3:list')")
    @GetMapping("/list")
    public TableDataInfo list(HospitalRatioLevel3 hospitalRatioLevel3)
    {
        startPage();
        List<HospitalRatioLevel3> list = hospitalRatioLevel3Service.selectHospitalRatioLevel3List(hospitalRatioLevel3);
        return getDataTable(list);
    }

    /**
     * 导出三级医院报销比例列表
     */
    @ApiOperation("导出三级医院报销比例列表")
    @PreAuthorize("@ss.hasPermi('system:level3:export')")
    @Log(title = "三级医院报销比例", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HospitalRatioLevel3 hospitalRatioLevel3)
    {
        List<HospitalRatioLevel3> list = hospitalRatioLevel3Service.selectHospitalRatioLevel3List(hospitalRatioLevel3);
        ExcelUtil<HospitalRatioLevel3> util = new ExcelUtil<HospitalRatioLevel3>(HospitalRatioLevel3.class);
        util.exportExcel(response, list, "三级医院报销比例数据");
    }

    /**
     * 获取三级医院报销比例详细信息
     */
    @ApiOperation("获取三级医院报销比例详细信息")
    @PreAuthorize("@ss.hasPermi('system:level3:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hospitalRatioLevel3Service.selectHospitalRatioLevel3ById(id));
    }

    /**
     * 新增三级医院报销比例
     */
    @ApiOperation("新增三级医院报销比例")
    @PreAuthorize("@ss.hasPermi('system:level3:add')")
    @Log(title = "三级医院报销比例", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HospitalRatioLevel3 hospitalRatioLevel3)
    {
        return toAjax(hospitalRatioLevel3Service.insertHospitalRatioLevel3(hospitalRatioLevel3));
    }

    /**
     * 修改三级医院报销比例
     */
    @ApiOperation("修改三级医院报销比例")
    @PreAuthorize("@ss.hasPermi('system:level3:edit')")
    @Log(title = "三级医院报销比例", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HospitalRatioLevel3 hospitalRatioLevel3)
    {
        return toAjax(hospitalRatioLevel3Service.updateHospitalRatioLevel3(hospitalRatioLevel3));
    }

    /**
     * 删除三级医院报销比例
     */
    @ApiOperation("删除三级医院报销比例")
    @PreAuthorize("@ss.hasPermi('system:level3:remove')")
    @Log(title = "三级医院报销比例", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hospitalRatioLevel3Service.deleteHospitalRatioLevel3ByIds(ids));
    }
}
