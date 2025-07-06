package com.neuedu.yyzx.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.yyzx.dto.BedDetailsDTO;
import com.neuedu.yyzx.dto.OutwardDTO;
import com.neuedu.yyzx.mapper.BedMapper;
import com.neuedu.yyzx.mapper.BeddetailsMapper;
import com.neuedu.yyzx.mapper.CustomerMapper;
import com.neuedu.yyzx.mapper.OutwardMapper;

import com.neuedu.yyzx.pojo.Outward;
import com.neuedu.yyzx.pojo.User;
import com.neuedu.yyzx.service.OutwardService;
import com.neuedu.yyzx.service.UserService;
import com.neuedu.yyzx.utils.ResultVo;
import com.neuedu.yyzx.vo.BedDetailsVo;
import com.neuedu.yyzx.vo.OutwardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutWardServiceImpl extends ServiceImpl<OutwardMapper, Outward> implements OutwardService {
    @Autowired
    private OutwardMapper outwardMapper;

    @Override
    public ResultVo<Page<OutwardVo>> listOutwardVoPage(OutwardDTO outwardDTO) throws Exception {
        Page<OutwardVo> page=new Page<>(outwardDTO.getPageSize(),6);
        outwardMapper.selectOutwardVo(page, outwardDTO.getUserId());
        return ResultVo.ok(page);
    }

    @Override
    public ResultVo examineOutward(Outward outward) throws Exception{
        UpdateWrapper<Outward> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("audit_status",outward.getAuditStatus());
        updateWrapper.eq("id",outward.getId());
        outwardMapper.update(outward,updateWrapper);
        return ResultVo.ok("审批成功");
    }
}
