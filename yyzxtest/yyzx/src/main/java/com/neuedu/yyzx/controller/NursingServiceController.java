package com.neuedu.yyzx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.yyzx.dto.NursingServiceDTO;
import com.neuedu.yyzx.dto.ServiceDTO;
import com.neuedu.yyzx.pojo.NursingService;
import com.neuedu.yyzx.service.NursingServiceService;
import com.neuedu.yyzx.utils.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;


@RestController
@RequestMapping("/nursingService")
@CrossOrigin
@Api(tags = "用户管理")
public class NursingServiceController {
    @Autowired
    private NursingServiceService serviceNursingService;

    @ApiOperation("查询全部用户-分页")
    @GetMapping("/findAllNursingServicePage")
    public ResultVo<Page<NursingService> > findAllNursingServicePage(NursingServiceDTO serviceDTO) throws  Exception{
        Page<NursingService> page = new Page<>(serviceDTO.getPageSize(),6);
        QueryWrapper qw = new QueryWrapper();
        qw.eq("is_deleted",0);
        serviceNursingService.page(page,qw);
        return ResultVo.ok(page);
    }
    @ApiOperation("添加用户")
    @PostMapping("/addNursingService")
    public ResultVo addNursingService(NursingService service) throws  Exception{
        service.setIsDeleted(0);
        serviceNursingService.save(service);
        return ResultVo.ok("添加成功");
    }

    @ApiOperation("修改用户")
    @PostMapping("/updateNursingService")
    public ResultVo updateNursingService(NursingService service) throws  Exception{
        UpdateWrapper<NursingService> updateWrapper = new UpdateWrapper<NursingService>();
        updateWrapper.eq("id",service.getId());
        serviceNursingService.update(service,updateWrapper);
        return ResultVo.ok("修改成功");
    }

    @ApiOperation("删除用户")
    @GetMapping("/delNursingService")
    public ResultVo delNursingService(NursingService service) throws  Exception{
        UpdateWrapper<NursingService> updateWrapper = new UpdateWrapper<NursingService>();
        updateWrapper.set("is_deleted",1);
        updateWrapper.eq("id",service.getId());
        serviceNursingService.update(service,updateWrapper);
        return ResultVo.ok("删除成功");
    }

    @ApiOperation("查询全部用户-分页")
    @GetMapping("/findNursingServicePage")
    public ResultVo<Page<NursingService> > findNursingServicePage(NursingServiceDTO nursingServiceDTO) throws  Exception{
        return  serviceNursingService.findNursingServicePage(nursingServiceDTO);
    }

    @ApiOperation("查询全部用户-分页")
    @GetMapping("/findNursingService")
    public ResultVo<List<NursingService>> findNursingService(NursingServiceDTO nursingServiceDTO) throws  Exception{
        return  serviceNursingService.findNursingService(nursingServiceDTO);
    }
}
