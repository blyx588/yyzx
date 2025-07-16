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
import com.health.system.domain.InpatientRegister;
import com.health.system.service.IInpatientRegisterService;
import com.health.common.utils.poi.ExcelUtil;
import com.health.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 入院登记管理Controller
 *
 * @author
 * @date 2025-07-09
 */
@Api(tags = "入院登记管理")
@RestController
@RequestMapping("/system/patient")
public class PatientController extends BaseController
{
    @Autowired
    private IInpatientRegisterService inpatientRegisterService;

    /**
     * 查询入院登记列表
     */
    @ApiOperation("查询入院登记列表（无分页）")
    @GetMapping("/listAt")
    public TableDataInfo listAt(InpatientRegister inpatientRegister)
    {
        startPage();
        List<InpatientRegister> list = inpatientRegisterService.selectInpatientRegisterList(inpatientRegister);
        return getDataTable(list);
    }

    /**
     * 查询入院登记列表
     */
    @ApiOperation("查询入院登记列表（分页）")
    @PreAuthorize("@ss.hasPermi('system:patient:list')")
    @GetMapping("/list")
    public TableDataInfo list(InpatientRegister inpatientRegister)
    {
        startPage();
        List<InpatientRegister> list = inpatientRegisterService.selectInpatientRegisterList(inpatientRegister);
        return getDataTable(list);
    }

    /**
     * 导出入院登记列表
     */
    @ApiOperation("导出入院登记列表")
    @PreAuthorize("@ss.hasPermi('system:patient:export')")
    @Log(title = "入院登记", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, InpatientRegister inpatientRegister)
    {
        List<InpatientRegister> list = inpatientRegisterService.selectInpatientRegisterList(inpatientRegister);
        ExcelUtil<InpatientRegister> util = new ExcelUtil<InpatientRegister>(InpatientRegister.class);
        util.exportExcel(response, list, "入院登记数据");
    }

    /**
     * 获取入院登记详细信息
     */
    @ApiOperation("获取入院登记详细信息")
    @PreAuthorize("@ss.hasPermi('system:patient:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(inpatientRegisterService.selectInpatientRegisterById(id));
    }

    /**
     * 新增入院登记
     */
    @ApiOperation("新增入院登记")
    @PreAuthorize("@ss.hasPermi('system:patient:add')")
    @Log(title = "入院登记", businessType = BusinessType.INSERT)
    @PostMapping("/register")
    public AjaxResult add(@RequestBody InpatientRegister inpatientRegister)
    {
        return toAjax(inpatientRegisterService.insertInpatientRegister(inpatientRegister));
    }

    /**
     * 修改入院登记
     */
    @ApiOperation("修改入院登记")
    @PreAuthorize("@ss.hasPermi('system:patient:edit')")
    @Log(title = "入院登记", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody InpatientRegister inpatientRegister)
    {
        return toAjax(inpatientRegisterService.updateInpatientRegister(inpatientRegister));
    }

    /**
     * 删除入院登记
     */
    @ApiOperation("删除入院登记")
    @PreAuthorize("@ss.hasPermi('system:patient:remove')")
    @Log(title = "入院登记", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(inpatientRegisterService.deleteInpatientRegisterByIds(ids));
    }

    /**
     * 导入入院登记
     */
    @ApiOperation("导入入院登记")
    @PreAuthorize("@ss.hasPermi('system:patient:add')")
    @Log(title = "入院登记", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<InpatientRegister> util = new ExcelUtil<>(InpatientRegister.class);
        List<InpatientRegister> registerList = util.importExcel(file.getInputStream());
        int successNum = 0;
        for (InpatientRegister register : registerList) {
            successNum += inpatientRegisterService.insertInpatientRegister(register);
        }
        return AjaxResult.success("成功导入" + successNum + "条数据");
    }
}