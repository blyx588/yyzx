package com.health.system.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.health.common.annotation.Excel;
import com.health.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 诊疗服务医嘱对象 doctor_service1
 *
 *  
 * @date 2025-07-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("诊疗服务医嘱实体")
public class DoctorService1 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    @ApiModelProperty("主键ID")
    private Long id;

    /** 医疗服务ID */
    @Excel(name = "医疗服务ID")
    @ApiModelProperty("医疗服务ID")
    private Long serviceId;

    /** 入院登记ID */
    @Excel(name = "入院登记ID")
    @ApiModelProperty("入院登记ID")
    private Long registerId;

    /** 医疗服务名称 */
    @Excel(name = "医疗服务名称")
    @ApiModelProperty("医疗服务名称")
    private String serviceName;

    /** 医疗服务编码 */
    @Excel(name = "医疗服务编码")
    @ApiModelProperty("医疗服务编码")
    private String serviceCode;

    /** 医疗服务除外内容 */
    @Excel(name = "医疗服务除外内容")
    @ApiModelProperty("医疗服务除外内容")
    private String exclusionContent;

    /** 计价单位 */
    @Excel(name = "计价单位")
    @ApiModelProperty("计价单位")
    private String unit;

    /** 价格 */
    @Excel(name = "价格")
    @ApiModelProperty("价格")
    private BigDecimal price;
}
