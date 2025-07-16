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
import com.health.system.domain.DiseaseIcd;
import com.health.system.service.IDiseaseIcdService;
import com.health.common.utils.poi.ExcelUtil;
import com.health.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 国际疾病分类Controller
 *
 *  
 * @date 2025-07-09
 */
@Api(tags = "疾病ICD接口")
@RestController
@RequestMapping("/system/icd")
public class DiseaseIcdController extends BaseController
{
    @Autowired
    private IDiseaseIcdService diseaseIcdService;

    /**
     * 查询国际疾病分类列表
     */
    @ApiOperation("查询国际疾病分类列表（无分页）")
    @GetMapping("/listAt")
    public TableDataInfo listAt(DiseaseIcd diseaseIcd)
    {
        startPage();
        List<DiseaseIcd> list = diseaseIcdService.selectDiseaseIcdList(diseaseIcd);
        return getDataTable(list);
    }

    /**
     * 查询国际疾病分类列表
     */
    @ApiOperation("查询国际疾病分类列表（分页）")
    @PreAuthorize("@ss.hasPermi('system:icd:list')")
    @GetMapping("/list")
    public TableDataInfo list(DiseaseIcd diseaseIcd)
    {
        startPage();
        List<DiseaseIcd> list = diseaseIcdService.selectDiseaseIcdList(diseaseIcd);
        return getDataTable(list);
    }

    /**
     * 导出国际疾病分类列表
     */
    @ApiOperation("导出国际疾病分类列表")
    @PreAuthorize("@ss.hasPermi('system:icd:export')")
    @Log(title = "国际疾病分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DiseaseIcd diseaseIcd)
    {
        List<DiseaseIcd> list = diseaseIcdService.selectDiseaseIcdList(diseaseIcd);
        ExcelUtil<DiseaseIcd> util = new ExcelUtil<DiseaseIcd>(DiseaseIcd.class);
        util.exportExcel(response, list, "国际疾病分类数据");
    }

    /**
     * 获取国际疾病分类详细信息
     */
    @ApiOperation("获取国际疾病分类详细信息")
    @PreAuthorize("@ss.hasPermi('system:icd:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(diseaseIcdService.selectDiseaseIcdById(id));
    }

    /**
     * 新增国际疾病分类
     */
    @ApiOperation("新增国际疾病分类")
    @PreAuthorize("@ss.hasPermi('system:icd:add')")
    @Log(title = "国际疾病分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DiseaseIcd diseaseIcd)
    {
        return toAjax(diseaseIcdService.insertDiseaseIcd(diseaseIcd));
    }

    /**
     * 修改国际疾病分类
     */
    @ApiOperation("修改国际疾病分类")
    @PreAuthorize("@ss.hasPermi('system:icd:edit')")
    @Log(title = "国际疾病分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DiseaseIcd diseaseIcd)
    {
        return toAjax(diseaseIcdService.updateDiseaseIcd(diseaseIcd));
    }

    /**
     * 删除国际疾病分类
     */
    @ApiOperation("删除国际疾病分类")
    @PreAuthorize("@ss.hasPermi('system:icd:remove')")
    @Log(title = "国际疾病分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(diseaseIcdService.deleteDiseaseIcdByIds(ids));
    }

    /**
     * 导入国际疾病分类
     */
    @PreAuthorize("@ss.hasPermi('system:icd:add')")
    @Log(title = "国际疾病分类", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<DiseaseIcd> util = new ExcelUtil<>(DiseaseIcd.class);
        List<DiseaseIcd> icdList = util.importExcel(file.getInputStream());
        int successNum = diseaseIcdService.batchInsertDiseaseIcd(icdList);
        return AjaxResult.success("成功导入" + successNum + "条数据");
    }
}
