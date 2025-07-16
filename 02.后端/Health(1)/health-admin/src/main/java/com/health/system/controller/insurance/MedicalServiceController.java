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
import com.health.system.domain.MedicalService;
import com.health.system.service.IMedicalServiceService;
import com.health.common.utils.poi.ExcelUtil;
import com.health.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 医疗服务项目Controller
 *
 *  
 * @date 2025-07-09
 */
@Api(tags = "医疗服务接口")
@RestController
@RequestMapping("/system/service")
public class MedicalServiceController extends BaseController
{
    @Autowired
    private IMedicalServiceService medicalServiceService;

    /**
     * 查询医疗服务项目列表
     */
    @ApiOperation("查询医疗服务项目列表（无分页）")
    @GetMapping("/listAt")
    public TableDataInfo listAt(MedicalService medicalService)
    {
        startPage();
        List<MedicalService> list = medicalServiceService.selectMedicalServiceList(medicalService);
        return getDataTable(list);
    }


    /**
     * 查询医疗服务项目列表
     */
    @ApiOperation("查询医疗服务项目列表（分页）")
    @PreAuthorize("@ss.hasPermi('system:service:list')")
    @GetMapping("/list")
    public TableDataInfo list(MedicalService medicalService)
    {
        startPage();
        List<MedicalService> list = medicalServiceService.selectMedicalServiceList(medicalService);
        return getDataTable(list);
    }

    /**
     * 导出医疗服务项目列表
     */
    @ApiOperation("导出医疗服务项目列表")
    @PreAuthorize("@ss.hasPermi('system:service:export')")
    @Log(title = "医疗服务项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MedicalService medicalService)
    {
        List<MedicalService> list = medicalServiceService.selectMedicalServiceList(medicalService);
        ExcelUtil<MedicalService> util = new ExcelUtil<MedicalService>(MedicalService.class);
        util.exportExcel(response, list, "医疗服务项目数据");
    }

    /**
     * 获取医疗服务项目详细信息
     */
    @ApiOperation("获取医疗服务项目详细信息")
    @PreAuthorize("@ss.hasPermi('system:service:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(medicalServiceService.selectMedicalServiceById(id));
    }

    /**
     * 新增医疗服务项目
     */
    @ApiOperation("新增医疗服务项目")
    @PreAuthorize("@ss.hasPermi('system:service:add')")
    @Log(title = "医疗服务项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MedicalService medicalService)
    {
        return toAjax(medicalServiceService.insertMedicalService(medicalService));
    }

    /**
     * 修改医疗服务项目
     */
    @ApiOperation("修改医疗服务项目")
    @PreAuthorize("@ss.hasPermi('system:service:edit')")
    @Log(title = "医疗服务项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MedicalService medicalService)
    {
        return toAjax(medicalServiceService.updateMedicalService(medicalService));
    }

    /**
     * 删除医疗服务项目
     */
    @ApiOperation("删除医疗服务项目")
    @PreAuthorize("@ss.hasPermi('system:service:remove')")
    @Log(title = "医疗服务项目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(medicalServiceService.deleteMedicalServiceByIds(ids));
    }

    /**
     * 导入医疗服务项目
     */
    @ApiOperation("导入医疗服务项目")
    @PreAuthorize("@ss.hasPermi('system:service:add')")
    @Log(title = "医疗服务项目", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<MedicalService> util = new ExcelUtil<>(MedicalService.class);
        List<MedicalService> serviceList = util.importExcel(file.getInputStream());
        int successNum = medicalServiceService.batchInsertMedicalService(serviceList);
        return AjaxResult.success("成功导入" + successNum + "条数据");
    }
}
