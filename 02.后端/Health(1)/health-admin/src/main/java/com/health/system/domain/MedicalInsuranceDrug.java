package com.health.system.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.health.common.annotation.Excel;
import com.health.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 医保药品信息对象 medical_insurance_drug
 *
 *  
 * @date 2025-07-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("医保药品实体")
public class MedicalInsuranceDrug extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    @ApiModelProperty("主键ID")
    private Long id;

    /** 分类 */
    @Excel(name = "分类")
    @ApiModelProperty("药品分类")
    private String category;

    /** 医保中文名称 */
    @Excel(name = "医保中文名称")
    @ApiModelProperty("医保中文名称")
    private String drugNameCn;

    /** 商品名 */
    @Excel(name = "商品名")
    @ApiModelProperty("商品名")
    private String tradeName;

    /** 规格 */
    @Excel(name = "规格")
    @ApiModelProperty("规格")
    private String specification;

    /** 单位 */
    @Excel(name = "单位")
    @ApiModelProperty("单位")
    private String unit;

    /** 生产企业 */
    @Excel(name = "生产企业")
    @ApiModelProperty("生产企业")
    private String manufacturer;

    /** 支付标准 */
    @Excel(name = "支付标准")
    @ApiModelProperty("支付标准")
    private BigDecimal paymentStandard;

    /** 备注 */
    @Excel(name = "备注")
    @ApiModelProperty("备注")
    private String remarks;

}
