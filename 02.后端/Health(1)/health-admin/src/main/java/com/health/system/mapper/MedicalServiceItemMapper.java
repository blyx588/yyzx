package com.health.system.mapper;

import java.util.List;

import com.health.common.enums.OperationType;
import com.health.system.annotation.AutoFill;
import com.health.system.domain.MedicalServiceItem;

/**
 * 诊疗项目Mapper接口
 *
 *  
 * @date 2025-07-09
 */
public interface MedicalServiceItemMapper
{
    /**
     * 查询诊疗项目
     *
     * @param id 诊疗项目主键
     * @return 诊疗项目
     */
    public MedicalServiceItem selectMedicalServiceItemById(Long id);

    /**
     * 查询诊疗项目列表
     *
     * @param medicalServiceItem 诊疗项目
     * @return 诊疗项目集合
     */
    public List<MedicalServiceItem> selectMedicalServiceItemList(MedicalServiceItem medicalServiceItem);

    /**
     * 新增诊疗项目
     *
     * @param medicalServiceItem 诊疗项目
     * @return 结果
     */
    @AutoFill(value = OperationType.INSERT)
    public int insertMedicalServiceItem(MedicalServiceItem medicalServiceItem);

    /**
     * 修改诊疗项目
     *
     * @param medicalServiceItem 诊疗项目
     * @return 结果
     */
    @AutoFill(value = OperationType.UPDATE)
    public int updateMedicalServiceItem(MedicalServiceItem medicalServiceItem);

    /**
     * 删除诊疗项目
     *
     * @param id 诊疗项目主键
     * @return 结果
     */
    public int deleteMedicalServiceItemById(Long id);

    /**
     * 批量删除诊疗项目
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMedicalServiceItemByIds(Long[] ids);

    /**
     * 批量插入诊疗项目
     * @param itemList 诊疗项目列表
     * @return 插入条数
     */
    @AutoFill(value = OperationType.INSERT)
    int batchInsertMedicalServiceItem(List<MedicalServiceItem> itemList);
}
