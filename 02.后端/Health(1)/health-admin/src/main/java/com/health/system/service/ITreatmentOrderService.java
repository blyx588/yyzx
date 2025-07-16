package com.health.system.service;

import java.util.List;
import com.health.system.domain.TreatmentOrder;

/**
 * 诊疗项目医嘱Service接口
 * 
 *  
 * @date 2025-07-10
 */
public interface ITreatmentOrderService 
{
    /**
     * 查询诊疗项目医嘱
     * 
     * @param id 诊疗项目医嘱主键
     * @return 诊疗项目医嘱
     */
    public TreatmentOrder selectTreatmentOrderById(Long id);

    /**
     * 查询诊疗项目医嘱列表
     * 
     * @param treatmentOrder 诊疗项目医嘱
     * @return 诊疗项目医嘱集合
     */
    public List<TreatmentOrder> selectTreatmentOrderList(TreatmentOrder treatmentOrder);

    /**
     * 新增诊疗项目医嘱
     * 
     * @param treatmentOrder 诊疗项目医嘱
     * @return 结果
     */
    public int insertTreatmentOrder(TreatmentOrder treatmentOrder);

    /**
     * 修改诊疗项目医嘱
     * 
     * @param treatmentOrder 诊疗项目医嘱
     * @return 结果
     */
    public int updateTreatmentOrder(TreatmentOrder treatmentOrder);

    /**
     * 批量删除诊疗项目医嘱
     * 
     * @param ids 需要删除的诊疗项目医嘱主键集合
     * @return 结果
     */
    public int deleteTreatmentOrderByIds(Long[] ids);

    /**
     * 删除诊疗项目医嘱信息
     * 
     * @param id 诊疗项目医嘱主键
     * @return 结果
     */
    public int deleteTreatmentOrderById(Long id);
} 