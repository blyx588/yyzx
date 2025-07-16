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
import com.health.system.domain.MedicalServiceItem;
import com.health.system.service.IMedicalServiceItemService;
import com.health.common.utils.poi.ExcelUtil;
import com.health.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 诊疗项目Controller
 *
 *  
 * @date 2025-07-09
 */
@Api(tags = "医疗服务项目接口")
@RestController
@RequestMapping("/system/item")
public class MedicalServiceItemController extends BaseController
{
    @Autowired
    private IMedicalServiceItemService medicalServiceItemService;

    /**
     * 查询诊疗项目列表
     */
    @ApiOperation("查询诊疗项目列表（无分页）")
    @GetMapping("/listAt")
    public TableDataInfo listAt(MedicalServiceItem medicalServiceItem)
    {
        startPage();
        List<MedicalServiceItem> list = medicalServiceItemService.selectMedicalServiceItemList(medicalServiceItem);
        return getDataTable(list);
    }

    /**
     * 查询诊疗项目列表
     */
    @ApiOperation("查询诊疗项目列表（分页）")
    @PreAuthorize("@ss.hasPermi('system:item:list')")
    @GetMapping("/list")
    public TableDataInfo list(MedicalServiceItem medicalServiceItem)
    {
        startPage();
        List<MedicalServiceItem> list = medicalServiceItemService.selectMedicalServiceItemList(medicalServiceItem);
        return getDataTable(list);
    }

    /**
     * 导出诊疗项目列表
     */
    @ApiOperation("导出诊疗项目列表")
    @PreAuthorize("@ss.hasPermi('system:item:export')")
    @Log(title = "诊疗项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MedicalServiceItem medicalServiceItem)
    {
        List<MedicalServiceItem> list = medicalServiceItemService.selectMedicalServiceItemList(medicalServiceItem);
        ExcelUtil<MedicalServiceItem> util = new ExcelUtil<MedicalServiceItem>(MedicalServiceItem.class);
        util.exportExcel(response, list, "诊疗项目数据");
    }

    /**
     * 获取诊疗项目详细信息
     */
    @ApiOperation("获取诊疗项目详细信息")
    @PreAuthorize("@ss.hasPermi('system:item:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(medicalServiceItemService.selectMedicalServiceItemById(id));
    }

    /**
     * 新增诊疗项目
     */
    @ApiOperation("新增诊疗项目")
    @PreAuthorize("@ss.hasPermi('system:item:add')")
    @Log(title = "诊疗项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MedicalServiceItem medicalServiceItem)
    {
        return toAjax(medicalServiceItemService.insertMedicalServiceItem(medicalServiceItem));
    }

    /**
     * 修改诊疗项目
     */
    @ApiOperation("修改诊疗项目")
    @PreAuthorize("@ss.hasPermi('system:item:edit')")
    @Log(title = "诊疗项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MedicalServiceItem medicalServiceItem)
    {
        return toAjax(medicalServiceItemService.updateMedicalServiceItem(medicalServiceItem));
    }

    /**
     * 删除诊疗项目
     */
    @ApiOperation("删除诊疗项目")
    @PreAuthorize("@ss.hasPermi('system:item:remove')")
    @Log(title = "诊疗项目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(medicalServiceItemService.deleteMedicalServiceItemByIds(ids));
    }

    /**
     * 导入诊疗项目
     */
    @ApiOperation("导入诊疗项目")
    @PreAuthorize("@ss.hasPermi('system:item:add')")
    @Log(title = "诊疗项目", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<MedicalServiceItem> util = new ExcelUtil<>(MedicalServiceItem.class);
        List<MedicalServiceItem> itemList = util.importExcel(file.getInputStream());
        int successNum = medicalServiceItemService.batchInsertMedicalServiceItem(itemList);
        return AjaxResult.success("成功导入" + successNum + "条数据");
    }
}
