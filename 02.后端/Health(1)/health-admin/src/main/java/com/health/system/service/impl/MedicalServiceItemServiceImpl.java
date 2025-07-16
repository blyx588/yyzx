package com.health.system.service.impl;

import java.util.List;
import com.health.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.health.system.mapper.MedicalServiceItemMapper;
import com.health.system.domain.MedicalServiceItem;
import com.health.system.service.IMedicalServiceItemService;

/**
 * 诊疗项目Service业务层处理
 * 
 *  
 * @date 2025-07-09
 */
@Service
public class MedicalServiceItemServiceImpl implements IMedicalServiceItemService 
{
    @Autowired
    private MedicalServiceItemMapper medicalServiceItemMapper;

    /**
     * 查询诊疗项目
     * 
     * @param id 诊疗项目主键
     * @return 诊疗项目
     */
    @Override
    public MedicalServiceItem selectMedicalServiceItemById(Long id)
    {
        return medicalServiceItemMapper.selectMedicalServiceItemById(id);
    }

    /**
     * 查询诊疗项目列表
     * 
     * @param medicalServiceItem 诊疗项目
     * @return 诊疗项目
     */
    @Override
    public List<MedicalServiceItem> selectMedicalServiceItemList(MedicalServiceItem medicalServiceItem)
    {
        return medicalServiceItemMapper.selectMedicalServiceItemList(medicalServiceItem);
    }

    /**
     * 新增诊疗项目
     * 
     * @param medicalServiceItem 诊疗项目
     * @return 结果
     */
    @Override
    public int insertMedicalServiceItem(MedicalServiceItem medicalServiceItem)
    {
        medicalServiceItem.setCreateTime(DateUtils.getNowDate());
        return medicalServiceItemMapper.insertMedicalServiceItem(medicalServiceItem);
    }

    /**
     * 修改诊疗项目
     * 
     * @param medicalServiceItem 诊疗项目
     * @return 结果
     */
    @Override
    public int updateMedicalServiceItem(MedicalServiceItem medicalServiceItem)
    {
        medicalServiceItem.setUpdateTime(DateUtils.getNowDate());
        return medicalServiceItemMapper.updateMedicalServiceItem(medicalServiceItem);
    }

    /**
     * 批量删除诊疗项目
     * 
     * @param ids 需要删除的诊疗项目主键
     * @return 结果
     */
    @Override
    public int deleteMedicalServiceItemByIds(Long[] ids)
    {
        return medicalServiceItemMapper.deleteMedicalServiceItemByIds(ids);
    }

    /**
     * 删除诊疗项目信息
     * 
     * @param id 诊疗项目主键
     * @return 结果
     */
    @Override
    public int deleteMedicalServiceItemById(Long id)
    {
        return medicalServiceItemMapper.deleteMedicalServiceItemById(id);
    }

    @Override
    public int batchInsertMedicalServiceItem(List<MedicalServiceItem> itemList) {
        if (itemList == null || itemList.isEmpty()) return 0;
        return medicalServiceItemMapper.batchInsertMedicalServiceItem(itemList);
    }
}
