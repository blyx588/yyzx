package com.neuedu.yyzx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="CheckoutDTO-用户查询条件", description="")
public class CheckoutDTO {
    @ApiModelProperty(value = "用户编号")
    private Integer userId;
    @ApiModelProperty(value = "页码")
    private Integer pageSize;
}
