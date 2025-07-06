package com.neuedu.yyzx.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.yyzx.dto.NurseRecordDTO;
import com.neuedu.yyzx.mapper.NurseRecordMapper;
import com.neuedu.yyzx.pojo.NurseRecord;
import com.neuedu.yyzx.service.NurseRecordService;
import com.neuedu.yyzx.utils.ResultVo;
import com.neuedu.yyzx.vo.NurseRecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NurseRecordServiceImpl extends ServiceImpl<NurseRecordMapper, NurseRecord> implements NurseRecordService {
    @Autowired
    NurseRecordMapper nurseRecordMapper;
    @Override
    public ResultVo<Page<NurseRecordVo>> queryNurseRecord(NurseRecordDTO nurseRecordDTO) {
        Page<NurseRecordVo> page = new Page<>(nurseRecordDTO.getPageSize(),6);
        nurseRecordMapper.queryNurseRecord(page,nurseRecordDTO.getCustomerId());
        return ResultVo.ok(page);
    }


}
