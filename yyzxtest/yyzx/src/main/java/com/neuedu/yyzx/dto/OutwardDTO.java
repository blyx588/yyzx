package com.neuedu.yyzx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="OutwardDTO-用户查询条件", description="")
public class OutwardDTO {
    @ApiModelProperty(value = "用户编号")
    private Integer userId;
    @ApiModelProperty(value = "页码")
    private Integer pageSize;
    @ApiModelProperty(value = "审批状态  0-已提交 1-同意  2-拒绝")
    private Integer auditStatus;
}
