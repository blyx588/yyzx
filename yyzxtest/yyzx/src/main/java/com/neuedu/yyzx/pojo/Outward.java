package com.neuedu.yyzx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Data;

import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Outward对象", description="")
public class Outward {
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "逻辑删除标记（0：显示；1：隐藏）")
    private int isDeleted;

    @ApiModelProperty(value = "客户ID")
    private String CustomerId;

    @ApiModelProperty(value = "外出事由")
    private String OutgoingReason;

    @ApiModelProperty(value = "外出时间")
    private Date OutgoingTime;

    @ApiModelProperty(value = "预计回院时间")
    private Date ExpectedReturnTime;

    @ApiModelProperty(value = "实际回院时间")
    private Date ActualReturnTime;

    @ApiModelProperty(value = "陪同人")
    private String Escorted;

    @ApiModelProperty(value = "与老人关系")
    private String Relation;

    @ApiModelProperty(value = "陪同人电话")
    private String EscortedTel;

    @ApiModelProperty(value = "审批状态  0-已提交 1-同意  2-拒绝")
    private Integer AuditStatus;

    @ApiModelProperty(value = "审批人")
    private String  AuditPerson;

    @ApiModelProperty(value = "审批时间")
    private Date  AuditTime;
}

