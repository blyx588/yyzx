package com.health.system.service.impl;

import java.util.List;
import com.health.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.health.system.mapper.InsuranceMapper;
import com.health.system.domain.Insurance;
import com.health.system.service.IInsuranceService;

/**
 * 药品报销比例Service业务层处理
 * 
 *  
 * @date 2025-07-09
 */
@Service
public class InsuranceServiceImpl implements IInsuranceService 
{
    @Autowired
    private InsuranceMapper insuranceMapper;

    /**
     * 查询药品报销比例
     * 
     * @param id 药品报销比例主键
     * @return 药品报销比例
     */
    @Override
    public Insurance selectInsuranceById(Long id)
    {
        return insuranceMapper.selectInsuranceById(id);
    }

    /**
     * 查询药品报销比例列表
     * 
     * @param insurance 药品报销比例
     * @return 药品报销比例
     */
    @Override
    public List<Insurance> selectInsuranceList(Insurance insurance)
    {
        return insuranceMapper.selectInsuranceList(insurance);
    }

    /**
     * 新增药品报销比例
     * 
     * @param insurance 药品报销比例
     * @return 结果
     */
    @Override
    public int insertInsurance(Insurance insurance)
    {
        insurance.setCreateTime(DateUtils.getNowDate());
        return insuranceMapper.insertInsurance(insurance);
    }

    /**
     * 修改药品报销比例
     * 
     * @param insurance 药品报销比例
     * @return 结果
     */
    @Override
    public int updateInsurance(Insurance insurance)
    {
        insurance.setUpdateTime(DateUtils.getNowDate());
        return insuranceMapper.updateInsurance(insurance);
    }

    /**
     * 批量删除药品报销比例
     * 
     * @param ids 需要删除的药品报销比例主键
     * @return 结果
     */
    @Override
    public int deleteInsuranceByIds(Long[] ids)
    {
        return insuranceMapper.deleteInsuranceByIds(ids);
    }

    /**
     * 删除药品报销比例信息
     * 
     * @param id 药品报销比例主键
     * @return 结果
     */
    @Override
    public int deleteInsuranceById(Long id)
    {
        return insuranceMapper.deleteInsuranceById(id);
    }
}
