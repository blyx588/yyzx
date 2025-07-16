package com.health.system.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.health.common.annotation.Excel;
import com.health.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 入院诊断对象 doctor_admission_diagnosis
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("入院诊断实体")
public class DoctorAdmissionDiagnosis extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    @ApiModelProperty("主键ID")
    private Long id;

    /** 入院登记ID */
    @Excel(name = "入院登记ID")
    @ApiModelProperty("入院登记ID")
    private Long registerId;

    /** 疾病ID */
    @Excel(name = "疾病ID")
    @ApiModelProperty("疾病ID")
    private Long diseaseId;

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

    /** 诊断类型(入院/初步) */
    @Excel(name = "诊断类型")
    @ApiModelProperty("诊断类型(入院/初步)")
    private String diagnosisType;

    /** 诊断描述 */
    @Excel(name = "诊断描述")
    @ApiModelProperty("诊断描述")
    private String diagnosisDesc;

    /** 诊断时间 */
    @Excel(name = "诊断时间")
    @ApiModelProperty("诊断时间")
    private String diagnosisTime;
}
