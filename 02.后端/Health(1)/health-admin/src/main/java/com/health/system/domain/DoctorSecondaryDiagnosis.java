package com.health.system.domain;

import com.health.common.annotation.Excel;
import com.health.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 其他诊断实体
 */
public class DoctorSecondaryDiagnosis extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 诊断ID */
    private Long id;

    /** 登记ID */
    @Excel(name = "登记ID")
    private Long registerId;

    /** 疾病ID */
    @Excel(name = "疾病ID")
    private Long diseaseId;

    /** ICD编码 */
    @Excel(name = "ICD编码")
    private String icdCode;

    /** 疾病编码 */
    @Excel(name = "疾病编码")
    private String diseaseCode;

    /** 疾病名称 */
    @Excel(name = "疾病名称")
    private String diseaseName;

    /** 疾病分类 */
    @Excel(name = "疾病分类")
    private String diseaseCategory;

    /** 诊断描述 */
    @Excel(name = "诊断描述")
    private String diagnosisDesc;

    /** 诊断时间 */
    @Excel(name = "诊断时间")
    private String diagnosisTime;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Long registerId) {
        this.registerId = registerId;
    }

    public Long getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Long diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode;
    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseCategory() {
        return diseaseCategory;
    }

    public void setDiseaseCategory(String diseaseCategory) {
        this.diseaseCategory = diseaseCategory;
    }

    public String getDiagnosisDesc() {
        return diagnosisDesc;
    }

    public void setDiagnosisDesc(String diagnosisDesc) {
        this.diagnosisDesc = diagnosisDesc;
    }

    public String getDiagnosisTime() {
        return diagnosisTime;
    }

    public void setDiagnosisTime(String diagnosisTime) {
        this.diagnosisTime = diagnosisTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("registerId", registerId)
                .append("diseaseId", diseaseId)
                .append("icdCode", icdCode)
                .append("diseaseCode", diseaseCode)
                .append("diseaseName", diseaseName)
                .append("diseaseCategory", diseaseCategory)
                .append("diagnosisDesc", diagnosisDesc)
                .append("diagnosisTime", diagnosisTime)
                .toString();
    }
}