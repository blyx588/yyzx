package com.neuedu.yyzx.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ServiceDTO {
    private Integer levelId;
    private Integer itemId;
    private Integer isDeleted;
    @ApiModelProperty(value = "页码")
    private Integer pageSize;
}
