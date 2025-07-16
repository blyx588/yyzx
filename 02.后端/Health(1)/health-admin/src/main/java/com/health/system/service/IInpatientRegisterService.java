package com.health.system.service;

import java.util.List;
import com.health.system.domain.InpatientRegister;

/**
 * 入院登记Service接口
 * 
 *  
 * @date 2025-07-09
 */
public interface IInpatientRegisterService 
{
    /**
     * 查询入院登记
     * 
     * @param id 入院登记主键
     * @return 入院登记
     */
    public InpatientRegister selectInpatientRegisterById(Long id);

    /**
     * 查询入院登记列表
     *
     * @param inpatientRegister 入院登记
     * @return 入院登记集合
     */
    public List<InpatientRegister> selectInpatientRegisterList(InpatientRegister inpatientRegister);

    /**
     * 新增入院登记
     *
     * @param inpatientRegister 入院登记
     * @return 结果
     */
    public int insertInpatientRegister(InpatientRegister inpatientRegister);

    /**
     * 修改入院登记
     *
     * @param inpatientRegister 入院登记
     * @return 结果
     */
    public int updateInpatientRegister(InpatientRegister inpatientRegister);

    /**
     * 批量删除入院登记
     *
     * @param ids 需要删除的入院登记主键集合
     * @return 结果
     */
    public int deleteInpatientRegisterByIds(Long[] ids);

    /**
     * 删除入院登记信息
     *
     * @param id 入院登记主键
     * @return 结果
     */
    public int deleteInpatientRegisterById(Long id);
}
