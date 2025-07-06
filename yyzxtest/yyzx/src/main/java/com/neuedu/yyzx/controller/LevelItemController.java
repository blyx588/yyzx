package com.neuedu.yyzx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.yyzx.dto.DelLevelItem;
import com.neuedu.yyzx.dto.NursingServiceDTO;
import com.neuedu.yyzx.dto.ServiceDTO;
import com.neuedu.yyzx.pojo.LevelItem;
import com.neuedu.yyzx.pojo.NursingService;
import com.neuedu.yyzx.service.LevelItemService;
import com.neuedu.yyzx.service.NursingServiceService;
import com.neuedu.yyzx.utils.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/levelItem")
@CrossOrigin
@Api(tags = "用户管理")
public class LevelItemController {
    @Autowired
    private LevelItemService levelItemService;

    @ApiOperation("查询全部用户-分页")
    @PostMapping("/addLevelItem")
    public ResultVo addLevelItem(LevelItem levelItem) throws  Exception{
        QueryWrapper<LevelItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("level_id", levelItem.getLevelId());
        queryWrapper.eq("item_id", levelItem.getItemId());
        int num = levelItemService.count(queryWrapper);
        if(num>0){
            return ResultVo.fail("已存在");
        }else {
            levelItemService.save(levelItem);
            return  ResultVo.ok("添加成功");
        }
    }

    @ApiOperation("根据ID删除 level_item")
    @PostMapping("/deleteLevelItem")
    public ResultVo deleteLevelItem(DelLevelItem delLevelItem) throws  Exception {
        QueryWrapper<LevelItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("level_id",delLevelItem.getLevelId());
        queryWrapper.eq("item_id",delLevelItem.getItemId());
        levelItemService.remove(queryWrapper);
        return  ResultVo.ok("删除成功");
    }

//    @ApiOperation("添加用户")
//    @PostMapping("/addNursingService")
//    public ResultVo addNursingService(NursingService service) throws  Exception{
//        service.setIsDeleted(0);
//        levelItemService.save(service);
//        return ResultVo.ok("添加成功");
//    }

//    @ApiOperation("修改用户")
//    @PostMapping("/updateNursingService")
//    public ResultVo updateNursingService(NursingService service) throws  Exception{
//        UpdateWrapper<NursingService> updateWrapper = new UpdateWrapper<NursingService>();
//        updateWrapper.eq("id",service.getId());
//        levelItemService.update(service,updateWrapper);
//        return ResultVo.ok("修改成功");
//    }

//    @ApiOperation("删除用户")
//    @GetMapping("/delNursingService")
//    public ResultVo delNursingService(NursingService service) throws  Exception{
//        UpdateWrapper<NursingService> updateWrapper = new UpdateWrapper<NursingService>();
//        updateWrapper.set("is_deleted",1);
//        updateWrapper.eq("id",service.getId());
//        levelItemService.update(service,updateWrapper);
//        return ResultVo.ok("删除成功");
//    }

//    @ApiOperation("查询全部用户-分页")
//    @GetMapping("/findNursingServicePage")
//    public ResultVo<Page<NursingService> > findNursingServicePage(ServiceDTO serviceDTO) throws  Exception{
//        Page<NursingService> page = new Page<>(serviceDTO.getPageSize(),6);
//        QueryWrapper qw = new QueryWrapper();
//        qw.eq("item_id",serviceDTO.getItemId());
//        qw.eq("is_deleted",0);
//        levelItemService.page(page,qw);
//        return ResultVo.ok(page);
//    }
}
