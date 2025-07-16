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
 * 诊疗项目对象 medical_service_item
 *
 *  
 * @date 2025-07-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("医疗服务项目明细实体")
public class MedicalServiceItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    @ApiModelProperty("主键ID")
    private Long id;

    /** 财务分类 */
    @Excel(name = "财务分类")
    @ApiModelProperty("财务分类")
    private String financeCategory;

    /** 项目编码 */
    @Excel(name = "项目编码")
    @ApiModelProperty("项目编码")
    private String itemCode;

    /** 国家编码 */
    @Excel(name = "国家编码")
    @ApiModelProperty("国家编码")
    private String nationalCode;

    /** 项目名称 */
    @Excel(name = "项目名称")
    @ApiModelProperty("项目名称")
    private String itemName;

    /** 项目内涵 */
    @Excel(name = "项目内涵")
    @ApiModelProperty("项目内涵")
    private String itemContent;

    /** 除外内容 */
    @Excel(name = "除外内容")
    @ApiModelProperty("除外内容")
    private String exclusionContent;

    /** 计价单位 */
    @Excel(name = "计价单位")
    @ApiModelProperty("计价单位")
    private String unit;

    /** 价格 */
    @Excel(name = "价格")
    @ApiModelProperty("价格")
    private BigDecimal price;

    /** 项目说明 */
    @Excel(name = "说明")
    @ApiModelProperty("项目说明")
    private String comments;

}
