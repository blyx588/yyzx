package com.neuedu.yyzx.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="OutwardVo对象", description="")
public class CheckoutVo implements Serializable {
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    @ApiModelProperty(value = "客户姓名")
    private String customerId;

    @ApiModelProperty(value = "逻辑删除标记（0：显示；1：隐藏）")
    private Integer isDeleted;

    @ApiModelProperty(value = "外出时间")
    private Date checkoutTime;

    @ApiModelProperty(value = "退住原因")
    private String CheckoutReason;

    @ApiModelProperty(value = "退住原因（0：死亡；1：正常；2：保留）")
    private Integer CheckoutType;

    @ApiModelProperty(value = "审批状态  0-已提交 1-同意  2-拒绝")
    private Integer auditStatus;

}
