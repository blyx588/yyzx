package com.health.system.mapper;

import java.util.List;

import com.health.common.enums.OperationType;
import com.health.system.annotation.AutoFill;
import com.health.system.domain.DiseaseIcd;
import org.apache.ibatis.annotations.Param;

/**
 * 国际疾病分类Mapper接口
 *
 *  
 * @date 2025-07-09
 */
public interface DiseaseIcdMapper
{
    /**
     * 查询国际疾病分类
     *
     * @param id 国际疾病分类主键
     * @return 国际疾病分类
     */
    public DiseaseIcd selectDiseaseIcdById(Long id);

    /**
     * 查询国际疾病分类列表
     *
     * @param diseaseIcd 国际疾病分类
     * @return 国际疾病分类集合
     */
    public List<DiseaseIcd> selectDiseaseIcdList(DiseaseIcd diseaseIcd);

    /**
     * 新增国际疾病分类
     *
     * @param diseaseIcd 国际疾病分类
     * @return 结果
     */
    @AutoFill(value = OperationType.INSERT)
    public int insertDiseaseIcd(DiseaseIcd diseaseIcd);

    /**
     * 修改国际疾病分类
     *
     * @param diseaseIcd 国际疾病分类
     * @return 结果
     */
    @AutoFill(value = OperationType.UPDATE)
    public int updateDiseaseIcd(DiseaseIcd diseaseIcd);

    /**
     * 删除国际疾病分类
     *
     * @param id 国际疾病分类主键
     * @return 结果
     */
    public int deleteDiseaseIcdById(Long id);

    /**
     * 批量删除国际疾病分类
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDiseaseIcdByIds(Long[] ids);

    /**
     * 批量插入国际疾病分类
     */
    @AutoFill(value = OperationType.INSERT)
    int batchInsertDiseaseIcd(@Param("list") List<DiseaseIcd> icdList);
}
