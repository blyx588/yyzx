package com.health.system.service.impl;

import java.util.List;
import com.health.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.health.system.mapper.InpatientRegisterMapper;
import com.health.system.domain.InpatientRegister;
import com.health.system.service.IInpatientRegisterService;

/**
 * 入院登记Service业务层处理
 * 
 *  
 * @date 2025-07-09
 */
@Service
public class InpatientRegisterServiceImpl implements IInpatientRegisterService 
{
    @Autowired
    private InpatientRegisterMapper inpatientRegisterMapper;

    /**
     * 查询入院登记
     * 
     * @param id 入院登记主键
     * @return 入院登记
     */
    @Override
    public InpatientRegister selectInpatientRegisterById(Long id)
    {
        return inpatientRegisterMapper.selectInpatientRegisterById(id);
    }

    /**
     * 查询入院登记列表
     *
     * @param inpatientRegister 入院登记
     * @return 入院登记
     */
    @Override
    public List<InpatientRegister> selectInpatientRegisterList(InpatientRegister inpatientRegister)
    {
        return inpatientRegisterMapper.selectInpatientRegisterList(inpatientRegister);
    }

    /**
     * 新增入院登记
     *
     * @param inpatientRegister 入院登记
     * @return 结果
     */
    @Override
    public int insertInpatientRegister(InpatientRegister inpatientRegister)
    {
        inpatientRegister.setCreateTime(DateUtils.getNowDate());
        return inpatientRegisterMapper.insertInpatientRegister(inpatientRegister);
    }

    /**
     * 修改入院登记
     *
     * @param inpatientRegister 入院登记
     * @return 结果
     */
    @Override
    public int updateInpatientRegister(InpatientRegister inpatientRegister)
    {
        inpatientRegister.setUpdateTime(DateUtils.getNowDate());
        return inpatientRegisterMapper.updateInpatientRegister(inpatientRegister);
    }

    /**
     * 批量删除入院登记
     *
     * @param ids 需要删除的入院登记主键
     * @return 结果
     */
    @Override
    public int deleteInpatientRegisterByIds(Long[] ids)
    {
        return inpatientRegisterMapper.deleteInpatientRegisterByIds(ids);
    }

    /**
     * 删除入院登记信息
     *
     * @param id 入院登记主键
     * @return 结果
     */
    @Override
    public int deleteInpatientRegisterById(Long id)
    {
        return inpatientRegisterMapper.deleteInpatientRegisterById(id);
    }
}
