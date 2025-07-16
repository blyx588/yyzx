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
 * 药品处方医嘱对象 doctor_prescription1
 *
 *  
 * @date 2025-07-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("药品处方医嘱实体")
public class DoctorPrescription1 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    @ApiModelProperty("主键ID")
    private Long id;

    /** 入院登记ID */
    @Excel(name = "入院登记ID")
    @ApiModelProperty("入院登记ID")
    private Long registerId;

    /** 药品ID */
    @Excel(name = "药品ID")
    @ApiModelProperty("药品ID")
    private Long drugId;

    /** 药品名称 */
    @Excel(name = "药品名称")
    @ApiModelProperty("药品名称")
    private String drugName;

    /** 单位 */
    @Excel(name = "单位")
    @ApiModelProperty("单位")
    private String unit;

    /** 规格 */
    @Excel(name = "规格")
    @ApiModelProperty("规格")
    private String specification;

    /** 生产企业 */
    @Excel(name = "生产企业")
    @ApiModelProperty("生产企业")
    private String manufacturer;

    /** 价格 */
    @Excel(name = "价格")
    @ApiModelProperty("价格")
    private BigDecimal price;

    /** 分类 */
    @Excel(name = "分类")
    @ApiModelProperty("分类")
    private String category;
}
