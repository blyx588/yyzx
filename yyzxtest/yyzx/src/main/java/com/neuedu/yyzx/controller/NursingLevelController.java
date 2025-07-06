package com.neuedu.yyzx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.yyzx.dto.NursingLevelDTO;
import com.neuedu.yyzx.pojo.NursingLevel;

import com.neuedu.yyzx.service.NursingLevelService;
import com.neuedu.yyzx.utils.ResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nursingLevel")
@CrossOrigin
@Api(tags = "护理管理")
public class NursingLevelController {
    @Autowired
    private NursingLevelService nursingLevelService;

    @ApiOperation("查询全部用户-分页")
    @GetMapping("/findAllNursingLevelPage")
    public ResultVo<Page<NursingLevel>> findAllNursingLevelPage(NursingLevelDTO nursingLevelDTO) throws Exception{
        Page<NursingLevel> page=new Page<>(nursingLevelDTO.getPageSize(),7);
        QueryWrapper qw = new QueryWrapper();
        qw.eq("level_status",nursingLevelDTO.getLevelStatus());
        nursingLevelService.page(page,qw);
        return ResultVo.ok(page);
    }

    @GetMapping("/findAllNursingLevel")
    public ResultVo<NursingLevel> findAllNursingLevel(NursingLevelDTO nursingLevelDTO) throws Exception{
        QueryWrapper<NursingLevel> qw = new QueryWrapper<>();
        if (nursingLevelDTO.getLevelStatus() != null) {
            qw.eq("level_status", nursingLevelDTO.getLevelStatus());
        }
        List<NursingLevel> list = nursingLevelService.list(qw);
        return ResultVo.ok(list);
    }
    @PostMapping("/UpdateNursingLevel")
    public ResultVo UpdateNursingLevel(NursingLevel nursingLevel) throws Exception{
        UpdateWrapper<NursingLevel> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("level_status",nursingLevel.getLevelStatus());
        updateWrapper.eq("id",nursingLevel.getId());
        nursingLevelService.update(nursingLevel,updateWrapper);
        return ResultVo.ok("修改成功");
    }

    @PostMapping("/addNursingLevel")
    public ResultVo addNursingLevel(NursingLevel nursingLevel) throws Exception{
        nursingLevel.setIsDeleted(0);
        nursingLevelService.save(nursingLevel);
        return ResultVo.ok("添加成功");
    }
}
