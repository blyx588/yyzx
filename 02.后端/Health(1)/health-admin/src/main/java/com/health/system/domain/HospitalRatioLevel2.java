package com.health.system.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.health.common.annotation.Excel;
import com.health.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 二级医院报销比例对象 hospital_ratio_level2
 *
 *  
 * @date 2025-07-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("二级医院报销比例实体")
public class HospitalRatioLevel2 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    @ApiModelProperty("主键ID")
    private Long id;

    /** 起付线（人民币元） */
    @Excel(name = "起付线", readConverterExp = "人=民币元")
    @ApiModelProperty("起付线（人民币元）")
    private BigDecimal deductible;

    /** 等级线（人民币元） */
    @Excel(name = "等级线", readConverterExp = "人=民币元")
    @ApiModelProperty("等级线（人民币元）")
    private BigDecimal levelLine;

    /** 人员类别（在职/退休） */
    @Excel(name = "人员类别", readConverterExp = "在=职/退休")
    @ApiModelProperty("人员类别（在职/退休）")
    private String personType;

    /** 报销比例（%） */
    @Excel(name = "报销比例", readConverterExp = "%=")
    @ApiModelProperty("报销比例（%）")
    private BigDecimal reimbursementRate;

    /** 状态（1正常 0停用） */
    @Excel(name = "状态", readConverterExp = "1=正常,0=停用")
    @ApiModelProperty("状态（1正常 0停用）")
    private Integer status;
}
