package com.health.system.service.impl;

import java.util.List;
import com.health.common.utils.DateUtils;
import com.health.system.domain.MedicalServiceItem;
import com.health.system.mapper.MedicalServiceItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.health.system.mapper.TreatmentOrderMapper;
import com.health.system.domain.TreatmentOrder;
import com.health.system.service.ITreatmentOrderService;

/**
 * 诊疗项目医嘱Service业务层处理
 *
 *  
 * @date 2025-07-10
 */
@Service
public class TreatmentOrderServiceImpl implements ITreatmentOrderService
{
    @Autowired
    private TreatmentOrderMapper treatmentOrderMapper;
    @Autowired
    private MedicalServiceItemMapper medicalServiceItemMapper;

    /**
     * 查询诊疗项目医嘱
     *
     * @param id 诊疗项目医嘱主键
     * @return 诊疗项目医嘱
     */
    @Override
    public TreatmentOrder selectTreatmentOrderById(Long id)
    {
        return treatmentOrderMapper.selectTreatmentOrderById(id);
    }

    /**
     * 查询诊疗项目医嘱列表
     *
     * @param treatmentOrder 诊疗项目医嘱
     * @return 诊疗项目医嘱
     */
    @Override
    public List<TreatmentOrder> selectTreatmentOrderList(TreatmentOrder treatmentOrder)
    {
        return treatmentOrderMapper.selectTreatmentOrderList(treatmentOrder);
    }

    /**
     * 新增诊疗项目医嘱
     *
     * @param treatmentOrder 诊疗项目医嘱
     * @return 结果
     */
    @Override
    public int insertTreatmentOrder(TreatmentOrder treatmentOrder)
    {
        // 获取诊疗项目信息
        MedicalServiceItem medicalServiceItem = medicalServiceItemMapper.selectMedicalServiceItemById(treatmentOrder.getItemId());
        // 填充诊疗项目信息
        treatmentOrder.setTreatmentName(medicalServiceItem.getItemName());
        treatmentOrder.setItemCode(medicalServiceItem.getItemCode());
        treatmentOrder.setExclusionContent(medicalServiceItem.getExclusionContent());
        treatmentOrder.setPrice(medicalServiceItem.getPrice());
        treatmentOrder.setUnit(medicalServiceItem.getUnit());
        // 新增诊疗项目医嘱
        return treatmentOrderMapper.insertTreatmentOrder(treatmentOrder);
    }

    /**
     * 修改诊疗项目医嘱
     *
     * @param treatmentOrder 诊疗项目医嘱
     * @return 结果
     */
    @Override
    public int updateTreatmentOrder(TreatmentOrder treatmentOrder)
    {
        treatmentOrder.setUpdateTime(DateUtils.getNowDate());
        return treatmentOrderMapper.updateTreatmentOrder(treatmentOrder);
    }

    /**
     * 批量删除诊疗项目医嘱
     *
     * @param ids 需要删除的诊疗项目医嘱主键
     * @return 结果
     */
    @Override
    public int deleteTreatmentOrderByIds(Long[] ids)
    {
        return treatmentOrderMapper.deleteTreatmentOrderByIds(ids);
    }

    /**
     * 删除诊疗项目医嘱信息
     *
     * @param id 诊疗项目医嘱主键
     * @return 结果
     */
    @Override
    public int deleteTreatmentOrderById(Long id)
    {
        return treatmentOrderMapper.deleteTreatmentOrderById(id);
    }
} 