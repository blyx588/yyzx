package com.neuedu.yyzx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.yyzx.dto.NurseRecordDTO;
import com.neuedu.yyzx.pojo.NurseRecord;
import com.neuedu.yyzx.utils.ResultVo;
import com.neuedu.yyzx.vo.NurseRecordVo;

public interface NurseRecordService extends IService<NurseRecord> {
    ResultVo<Page<NurseRecordVo>> queryNurseRecord(NurseRecordDTO nurseRecordDTO);
}
