package com.neuedu.yyzx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="NursingServiceDTO-用户查询条件", description="")
public class NursingServiceDTO {
    @ApiModelProperty(value = "页码")
    private Integer pageSize;
    private Integer levelId;
    private Integer status;
}
