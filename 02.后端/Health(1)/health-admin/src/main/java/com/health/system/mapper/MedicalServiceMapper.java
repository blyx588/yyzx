package com.health.system.mapper;

import java.util.List;

import com.health.common.enums.OperationType;
import com.health.system.annotation.AutoFill;
import com.health.system.domain.MedicalService;
import org.apache.ibatis.annotations.Param;

/**
 * 医疗服务项目Mapper接口
 *
 *  
 * @date 2025-07-09
 */
public interface MedicalServiceMapper
{
    /**
     * 查询医疗服务项目
     *
     * @param id 医疗服务项目主键
     * @return 医疗服务项目
     */
    public MedicalService selectMedicalServiceById(Long id);

    /**
     * 查询医疗服务项目列表
     *
     * @param medicalService 医疗服务项目
     * @return 医疗服务项目集合
     */
    public List<MedicalService> selectMedicalServiceList(MedicalService medicalService);

    /**
     * 新增医疗服务项目
     *
     * @param medicalService 医疗服务项目
     * @return 结果
     */
    @AutoFill(value = OperationType.INSERT)
    public int insertMedicalService(MedicalService medicalService);

    /**
     * 修改医疗服务项目
     *
     * @param medicalService 医疗服务项目
     * @return 结果
     */
    @AutoFill(value = OperationType.UPDATE)
    public int updateMedicalService(MedicalService medicalService);

    /**
     * 删除医疗服务项目
     *
     * @param id 医疗服务项目主键
     * @return 结果
     */
    public int deleteMedicalServiceById(Long id);

    /**
     * 批量删除医疗服务项目
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMedicalServiceByIds(Long[] ids);

    /**
     * 批量插入医疗服务项目
     */
    @AutoFill(value = OperationType.INSERT)
    int batchInsertMedicalService(@Param("list") List<MedicalService> serviceList);
}
