package com.neuedu.yyzx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.yyzx.dto.OutwardDTO;
import com.neuedu.yyzx.dto.OutwardDTO;
import com.neuedu.yyzx.pojo.Customer;
import com.neuedu.yyzx.pojo.Outward;
import com.neuedu.yyzx.pojo.Outward;
import com.neuedu.yyzx.pojo.Outward;
import com.neuedu.yyzx.service.OutwardService;
import com.neuedu.yyzx.service.OutwardService;
import com.neuedu.yyzx.utils.ResultVo;
import com.neuedu.yyzx.vo.OutwardVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/outward")
@CrossOrigin
@Api(tags = "外出登记")
public class OutwardController {
    @Autowired
    private OutwardService outwardService;


    @ApiOperation("添加外出记录")
    @PostMapping("/addRecords")
    public ResultVo addRecords(Outward outward) {
        outward.setIsDeleted(0);
        outward.setAuditStatus(0);
        outwardService.save(outward);
        return ResultVo.ok("添加成功");
    }

//    @ApiOperation("登记信息查询")
//    @PostMapping("/viewOutward")
//    public ResultVo<Page<Outward>> queryOutwardPage(OutwardDTO outwardDTO) throws Exception{
//
//    }
//
    @ApiOperation("查询全部用户-分页")
    @GetMapping("/findAllOutwardPage")
    public ResultVo<Page<OutwardVo>> listOutwardVoPage(OutwardDTO outwardDTO) throws Exception{
        return outwardService.listOutwardVoPage(outwardDTO);
    }

    @ApiOperation("审批申请")
    @PostMapping("/examineOutward")
    public ResultVo examineOutward(Outward outward) throws Exception{
        return outwardService.examineOutward(outward);
    }

    @ApiOperation("撤回申请")
    @PostMapping("/recallApplication")
    public ResultVo recallApplication(Outward outward) throws Exception{
        UpdateWrapper<Outward> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("is_deleted", 1);
        updateWrapper.eq("id",outward.getId());
        outwardService.update(outward,updateWrapper);
        return ResultVo.ok("修改成功");
    }


    @PostMapping("/updateActualBackTime")
    public ResultVo UpdateActualBackTime(Outward outward) throws Exception{
        UpdateWrapper<Outward> updateWrapper = new UpdateWrapper<>();

        updateWrapper.eq("id",outward.getId());
        outwardService.update(outward,updateWrapper);
        return ResultVo.ok("修改成功");
    }
}
