package com.health.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
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
 * 入院登记对象 inpatient_register
 *
 *  
 * @date 2025-07-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("入院登记实体")
public class InpatientRegister extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    @ApiModelProperty("主键ID")
    private Long id;

    /** 住院号 */
    @Excel(name = "住院号")
    @ApiModelProperty("住院号")
    private String admissionNo;

    /** 姓名 */
    @Excel(name = "姓名")
    @ApiModelProperty("姓名")
    private String name;

    /** 身份证号 */
    @Excel(name = "身份证号")
    @ApiModelProperty("身份证号")
    private String idCard;

    /** 年龄 */
    @Excel(name = "年龄")
    @ApiModelProperty("年龄")
    private Long age;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("出生日期")
    private Date birthDate;

    /** 性别 */
    @Excel(name = "性别")
    @ApiModelProperty("性别")
    private String gender;

    /** 家庭住址 */
    @Excel(name = "家庭住址")
    @ApiModelProperty("家庭住址")
    private String address;

    /** 结算类别 */
    @Excel(name = "结算类别")
    @ApiModelProperty("结算类别")
    private String settlementType;

    /** 工作状态 */
    @Excel(name = "工作状态")
    @ApiModelProperty("工作状态")
    private String workStatus;

    /** 入院时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "入院时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("入院时间")
    private Date admissionTime;
}
