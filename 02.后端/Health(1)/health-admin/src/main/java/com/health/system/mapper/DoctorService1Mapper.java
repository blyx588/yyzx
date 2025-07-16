package com.health.system.mapper;

import java.util.List;
import com.health.system.domain.DoctorService1;

/**
 * 诊疗服务医嘱Mapper接口
 * 
 *  
 * @date 2025-07-10
 */
public interface DoctorService1Mapper 
{
    /**
     * 查询诊疗服务医嘱
     * 
     * @param id 诊疗服务医嘱主键
     * @return 诊疗服务医嘱
     */
    public DoctorService1 selectDoctorService1ById(Long id);

    /**
     * 查询诊疗服务医嘱列表
     * 
     * @param doctorService1 诊疗服务医嘱
     * @return 诊疗服务医嘱集合
     */
    public List<DoctorService1> selectDoctorService1List(DoctorService1 doctorService1);

    /**
     * 新增诊疗服务医嘱
     * 
     * @param doctorService1 诊疗服务医嘱
     * @return 结果
     */
    public int insertDoctorService1(DoctorService1 doctorService1);

    /**
     * 修改诊疗服务医嘱
     * 
     * @param doctorService1 诊疗服务医嘱
     * @return 结果
     */
    public int updateDoctorService1(DoctorService1 doctorService1);

    /**
     * 删除诊疗服务医嘱
     * 
     * @param id 诊疗服务医嘱主键
     * @return 结果
     */
    public int deleteDoctorService1ById(Long id);

    /**
     * 批量删除诊疗服务医嘱
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDoctorService1ByIds(Long[] ids);

    /**
     * 根据registerId查询医疗服务单
     */
    List<DoctorService1> selectDoctorService1ListByRegisterId(Long registerId);
}
