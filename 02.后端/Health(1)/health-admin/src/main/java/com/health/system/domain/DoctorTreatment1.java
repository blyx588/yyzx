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
 * 诊疗项目医嘱对象 doctor_treatment1
 *
 *  
 * @date 2025-07-10
 */
@ApiModel("诊疗项目医嘱实体")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorTreatment1 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    @ApiModelProperty("主键ID")
    private Long id;

    /** 诊疗项目ID */
    @Excel(name = "诊疗项目ID")
    @ApiModelProperty("诊疗项目ID")
    private Long itemId;

    /** 入院登记ID */
    @Excel(name = "入院登记ID")
    @ApiModelProperty("入院登记ID")
    private Long registerId;

    /** 诊疗项目名称 */
    @Excel(name = "诊疗项目名称")
    @ApiModelProperty("诊疗项目名称")
    private String treatmentName;

    /** 诊疗项目编码 */
    @Excel(name = "诊疗项目编码")
    @ApiModelProperty("诊疗项目编码")
    private String itemCode;

    /** 诊疗项目除外内容 */
    @Excel(name = "诊疗项目除外内容")
    @ApiModelProperty("诊疗项目除外内容")
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
