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
import com.health.system.domain.MedicalInsuranceDrug;
import com.health.system.service.IMedicalInsuranceDrugService;
import com.health.common.utils.poi.ExcelUtil;
import com.health.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 医保药品信息Controller
 *
 *  
 * @date 2025-07-09
 */
@Api(tags = "医保药品接口")
@RestController
@RequestMapping("/system/drug")
public class MedicalInsuranceDrugController extends BaseController
{
    @Autowired
    private IMedicalInsuranceDrugService medicalInsuranceDrugService;

    /**
     * 查询医保药品信息列表
     */
    @ApiOperation("查询医保药品信息列表（无分页）")
    @GetMapping("/listAt")
    public TableDataInfo listAt(MedicalInsuranceDrug medicalInsuranceDrug)
    {
        startPage();
        List<MedicalInsuranceDrug> list = medicalInsuranceDrugService.selectMedicalInsuranceDrugList(medicalInsuranceDrug);
        return getDataTable(list);
    }

    /**
     * 查询医保药品信息列表
     */
    @ApiOperation("查询医保药品信息列表（分页）")
    @PreAuthorize("@ss.hasPermi('system:drug:list')")
    @GetMapping("/list")
    public TableDataInfo list(MedicalInsuranceDrug medicalInsuranceDrug)
    {
        startPage();
        List<MedicalInsuranceDrug> list = medicalInsuranceDrugService.selectMedicalInsuranceDrugList(medicalInsuranceDrug);
        return getDataTable(list);
    }

    /**
     * 导出医保药品信息列表
     */
    @ApiOperation("导出医保药品信息列表")
    @PreAuthorize("@ss.hasPermi('system:drug:export')")
    @Log(title = "医保药品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MedicalInsuranceDrug medicalInsuranceDrug)
    {
        List<MedicalInsuranceDrug> list = medicalInsuranceDrugService.selectMedicalInsuranceDrugList(medicalInsuranceDrug);
        ExcelUtil<MedicalInsuranceDrug> util = new ExcelUtil<MedicalInsuranceDrug>(MedicalInsuranceDrug.class);
        util.exportExcel(response, list, "医保药品信息数据");
    }

    /**
     * 获取医保药品信息详细信息
     */
    @ApiOperation("获取医保药品信息详细信息")
    @PreAuthorize("@ss.hasPermi('system:drug:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(medicalInsuranceDrugService.selectMedicalInsuranceDrugById(id));
    }

    /**
     * 新增医保药品信息
     */
    @ApiOperation("新增医保药品信息")
    @PreAuthorize("@ss.hasPermi('system:drug:add')")
    @Log(title = "医保药品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MedicalInsuranceDrug medicalInsuranceDrug)
    {
        return toAjax(medicalInsuranceDrugService.insertMedicalInsuranceDrug(medicalInsuranceDrug));
    }

    /**
     * 修改医保药品信息
     */
    @ApiOperation("修改医保药品信息")
    @PreAuthorize("@ss.hasPermi('system:drug:edit')")
    @Log(title = "医保药品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MedicalInsuranceDrug medicalInsuranceDrug)
    {
        return toAjax(medicalInsuranceDrugService.updateMedicalInsuranceDrug(medicalInsuranceDrug));
    }

    /**
     * 删除医保药品信息
     */
    @ApiOperation("删除医保药品信息")
    @PreAuthorize("@ss.hasPermi('system:drug:remove')")
    @Log(title = "医保药品信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(medicalInsuranceDrugService.deleteMedicalInsuranceDrugByIds(ids));
    }

    /**
     * 导入医保药品信息
     */
    @ApiOperation("导入医保药品信息")
    @PreAuthorize("@ss.hasPermi('system:drug:add')")
    @Log(title = "医保药品信息", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<MedicalInsuranceDrug> util = new ExcelUtil<>(MedicalInsuranceDrug.class);
        List<MedicalInsuranceDrug> drugList = util.importExcel(file.getInputStream());
        int successNum = medicalInsuranceDrugService.batchInsertMedicalInsuranceDrug(drugList);
        return AjaxResult.success("成功导入" + successNum + "条数据");
    }
}
