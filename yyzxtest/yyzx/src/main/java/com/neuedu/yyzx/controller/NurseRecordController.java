package com.neuedu.yyzx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.yyzx.dto.NurseRecordDTO;
import com.neuedu.yyzx.pojo.CustomerNurseItem;
import com.neuedu.yyzx.pojo.NurseRecord;
import com.neuedu.yyzx.service.CustomerNurseItemService;
import com.neuedu.yyzx.service.NurseRecordService;
import com.neuedu.yyzx.utils.ResultVo;
import com.neuedu.yyzx.vo.NurseRecordVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nurseRecord")
@CrossOrigin
@Api(tags = "护理记录")
public class NurseRecordController {
@Autowired
    private NurseRecordService nurseRecordService;
@Autowired
    private CustomerNurseItemService customerNurseItemService;

    @GetMapping("/queryNurseRecord")
    public ResultVo<Page<NurseRecordVo>> queryNurseRecord(NurseRecordDTO nurseRecordDTO) {
        return nurseRecordService.queryNurseRecord(nurseRecordDTO);
    }

    @PostMapping("/deleted")
    public ResultVo deleted( NurseRecordDTO nurseRecordDTO) {
        UpdateWrapper<NurseRecord> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("is_deleted", 0);
        updateWrapper.eq("id", nurseRecordDTO.getId());
        nurseRecordService.update(updateWrapper);
        return ResultVo.ok("删除成功");
    }

    @PostMapping("/addNurseRecord")
    public ResultVo addNurseRecord(NurseRecord nurseRecord) {
        QueryWrapper<CustomerNurseItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customer_id", nurseRecord.getCustomerId());
        queryWrapper.eq("item_id", nurseRecord.getItemId());
        queryWrapper.eq("is_deleted", 1);

        CustomerNurseItem item = customerNurseItemService.getOne(queryWrapper);

        if (item == null) {
            return ResultVo.fail("未找到对应的护理项目！");
        }

        if (nurseRecord.getNursingCount() > item.getNurseNumber()) {
            return ResultVo.fail("护理次数已超出剩余数量，无法添加！");
        }

        item.setNurseNumber(item.getNurseNumber() - nurseRecord.getNursingCount());
        UpdateWrapper<CustomerNurseItem> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("nurse_number", item.getNurseNumber());
        updateWrapper.eq("customer_id", nurseRecord.getCustomerId());
        updateWrapper.eq("item_id", nurseRecord.getItemId());
        updateWrapper.eq("is_deleted", 1);
        customerNurseItemService.update(updateWrapper);
        nurseRecordService.save(nurseRecord);
        return ResultVo.ok("添加成功");
    }
}
