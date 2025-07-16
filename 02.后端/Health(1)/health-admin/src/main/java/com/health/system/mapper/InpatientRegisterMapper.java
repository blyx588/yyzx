package com.health.system.mapper;

import java.util.List;

import com.health.common.enums.OperationType;
import com.health.system.annotation.AutoFill;
import com.health.system.domain.InpatientRegister;

/**
 * 入院登记Mapper接口
 *
 *  
 * @date 2025-07-09
 */
public interface InpatientRegisterMapper
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
    @AutoFill(value = OperationType.INSERT)
    public int insertInpatientRegister(InpatientRegister inpatientRegister);

    /**
     * 修改入院登记
     *
     * @param inpatientRegister 入院登记
     * @return 结果
     */
    @AutoFill(value = OperationType.UPDATE)
    public int updateInpatientRegister(InpatientRegister inpatientRegister);

    /**
     * 删除入院登记
     *
     * @param id 入院登记主键
     * @return 结果
     */
    public int deleteInpatientRegisterById(Long id);

    /**
     * 批量删除入院登记
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInpatientRegisterByIds(Long[] ids);
}
