package com.health.system.mapper;

import java.util.List;

import com.health.common.enums.OperationType;
import com.health.system.annotation.AutoFill;
import com.health.system.domain.MedicalInsuranceDrug;
import org.apache.ibatis.annotations.Param;

/**
 * 医保药品信息Mapper接口
 *
 *  
 * @date 2025-07-09
 */
public interface MedicalInsuranceDrugMapper
{
    /**
     * 查询医保药品信息
     *
     * @param id 医保药品信息主键
     * @return 医保药品信息
     */
    public MedicalInsuranceDrug selectMedicalInsuranceDrugById(Long id);

    /**
     * 查询医保药品信息列表
     *
     * @param medicalInsuranceDrug 医保药品信息
     * @return 医保药品信息集合
     */
    public List<MedicalInsuranceDrug> selectMedicalInsuranceDrugList(MedicalInsuranceDrug medicalInsuranceDrug);

    /**
     * 新增医保药品信息
     *
     * @param medicalInsuranceDrug 医保药品信息
     * @return 结果
     */
    @AutoFill(value = OperationType.INSERT)
    public int insertMedicalInsuranceDrug(MedicalInsuranceDrug medicalInsuranceDrug);

    /**
     * 修改医保药品信息
     *
     * @param medicalInsuranceDrug 医保药品信息
     * @return 结果
     */
    @AutoFill(value = OperationType.UPDATE)
    public int updateMedicalInsuranceDrug(MedicalInsuranceDrug medicalInsuranceDrug);

    /**
     * 删除医保药品信息
     *
     * @param id 医保药品信息主键
     * @return 结果
     */
    public int deleteMedicalInsuranceDrugById(Long id);

    /**
     * 批量删除医保药品信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMedicalInsuranceDrugByIds(Long[] ids);

    /**
     * 批量插入医保药品信息
     * @param drugList 药品列表
     * @return 插入条数
     */
    @AutoFill(value = OperationType.INSERT)
    int batchInsertMedicalInsuranceDrug(List<MedicalInsuranceDrug> drugList);

    /**
     * 根据医保中文名称、规格、生产企业唯一性查询
     */
    MedicalInsuranceDrug selectByUnique(@Param("drugNameCn") String drugNameCn, @Param("specification") String specification, @Param("manufacturer") String manufacturer);
}
