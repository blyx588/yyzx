package com.health.system.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.health.common.annotation.Excel;
import com.health.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("主要诊断实体")
public class DoctorPrimaryDiagnosis extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    private Long id;

    @Excel(name = "入院登记ID")
    @ApiModelProperty("入院登记ID")
    private Long registerId;

    @Excel(name = "疾病ID")
    @ApiModelProperty("疾病ID")
    private Long diseaseId;

    @Excel(name = "国际ICD编码")
    @ApiModelProperty("国际ICD编码")
    private String icdCode;

    @Excel(name = "疾病编码")
    @ApiModelProperty("疾病编码")
    private String diseaseCode;

    @Excel(name = "疾病名称")
    @ApiModelProperty("疾病名称")
    private String diseaseName;

    @Excel(name = "疾病分类")
    @ApiModelProperty("疾病分类")
    private String diseaseCategory;

    @Excel(name = "诊断描述")
    @ApiModelProperty("诊断描述")
    private String diagnosisDesc;

    @Excel(name = "确诊时间")
    @ApiModelProperty("确诊时间")
    private String diagnosisTime;

    @Excel(name = "是否并发症")
    @ApiModelProperty("是否并发症(0否 1是)")
    private Integer isComplication;

    @Excel(name = "严重程度")
    @ApiModelProperty("严重程度")
    private String severity;

    @Excel(name = "治疗效果")
    @ApiModelProperty("治疗效果")
    private String treatmentEffect;
}