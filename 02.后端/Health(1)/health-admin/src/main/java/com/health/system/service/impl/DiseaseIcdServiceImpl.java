package com.health.system.service.impl;

import java.util.List;
import com.health.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.health.system.mapper.DiseaseIcdMapper;
import com.health.system.domain.DiseaseIcd;
import com.health.system.service.IDiseaseIcdService;

/**
 * 国际疾病分类Service业务层处理
 * 
 *  
 * @date 2025-07-09
 */
@Service
public class DiseaseIcdServiceImpl implements IDiseaseIcdService 
{
    @Autowired
    private DiseaseIcdMapper diseaseIcdMapper;

    /**
     * 查询国际疾病分类
     * 
     * @param id 国际疾病分类主键
     * @return 国际疾病分类
     */
    @Override
    public DiseaseIcd selectDiseaseIcdById(Long id)
    {
        return diseaseIcdMapper.selectDiseaseIcdById(id);
    }

    /**
     * 查询国际疾病分类列表
     * 
     * @param diseaseIcd 国际疾病分类
     * @return 国际疾病分类
     */
    @Override
    public List<DiseaseIcd> selectDiseaseIcdList(DiseaseIcd diseaseIcd)
    {
        return diseaseIcdMapper.selectDiseaseIcdList(diseaseIcd);
    }

    /**
     * 新增国际疾病分类
     * 
     * @param diseaseIcd 国际疾病分类
     * @return 结果
     */
    @Override
    public int insertDiseaseIcd(DiseaseIcd diseaseIcd)
    {
        diseaseIcd.setCreateTime(DateUtils.getNowDate());
        return diseaseIcdMapper.insertDiseaseIcd(diseaseIcd);
    }

    /**
     * 修改国际疾病分类
     * 
     * @param diseaseIcd 国际疾病分类
     * @return 结果
     */
    @Override
    public int updateDiseaseIcd(DiseaseIcd diseaseIcd)
    {
        diseaseIcd.setUpdateTime(DateUtils.getNowDate());
        return diseaseIcdMapper.updateDiseaseIcd(diseaseIcd);
    }

    /**
     * 批量删除国际疾病分类
     * 
     * @param ids 需要删除的国际疾病分类主键
     * @return 结果
     */
    @Override
    public int deleteDiseaseIcdByIds(Long[] ids)
    {
        return diseaseIcdMapper.deleteDiseaseIcdByIds(ids);
    }

    /**
     * 删除国际疾病分类信息
     * 
     * @param id 国际疾病分类主键
     * @return 结果
     */
    @Override
    public int deleteDiseaseIcdById(Long id)
    {
        return diseaseIcdMapper.deleteDiseaseIcdById(id);
    }

    @Override
    public int batchInsertDiseaseIcd(List<DiseaseIcd> icdList) {
        return diseaseIcdMapper.batchInsertDiseaseIcd(icdList);
    }
}
