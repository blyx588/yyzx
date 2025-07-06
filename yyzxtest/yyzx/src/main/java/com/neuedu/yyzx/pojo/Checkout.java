package com.neuedu.yyzx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Checkout对象", description="")
public class Checkout {
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "逻辑删除标记（0：显示；1：隐藏）")
    private int isDeleted;

    @ApiModelProperty(value = "客户ID")
    private String CustomerId;

    @ApiModelProperty(value = "退住原因")
    private String CheckoutReason;

    @ApiModelProperty(value = "退住时间")
    private Date CheckoutTime;

    @ApiModelProperty(value = "退住类型（0：死亡；1：正常；2：保留）")
    private Integer CheckoutType;


    @ApiModelProperty(value = "审批状态  0-已提交 1-同意  2-拒绝")
    private Integer AuditStatus;

    @ApiModelProperty(value = "审批人")
    private String  AuditPerson;

    @ApiModelProperty(value = "审批时间")
    private Date  AuditTime;
}

