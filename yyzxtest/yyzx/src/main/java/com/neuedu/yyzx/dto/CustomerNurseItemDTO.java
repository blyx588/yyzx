package com.neuedu.yyzx.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerNurseItemDTO {
    private Integer levelId;

    @ApiModelProperty(value = "页码")
    private Integer pageSize;
}
