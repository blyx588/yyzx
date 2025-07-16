package com.health.system.domain;

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
 * 国际疾病分类对象 disease_icd
 *
 *  
 * @date 2025-07-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("疾病ICD实体")
public class DiseaseIcd extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    @ApiModelProperty("主键ID")
    private Long id;

    /** 国际ICD编码 */
    @Excel(name = "国际ICD编码")
    @ApiModelProperty("国际ICD编码")
    private String icdCode;

    /** 疾病编码 */
    @Excel(name = "疾病编码")
    @ApiModelProperty("疾病编码")
    private String diseaseCode;

    /** 疾病名称 */
    @Excel(name = "疾病名称")
    @ApiModelProperty("疾病名称")
    private String diseaseName;

    /** 疾病分类 */
    @Excel(name = "疾病分类")
    @ApiModelProperty("疾病分类")
    private String diseaseCategory;
}
