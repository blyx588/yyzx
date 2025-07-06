package com.neuedu.yyzx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="CustomerDTO-客户查询条件", description="")
public class CustomerDTO {
    @ApiModelProperty(value = "系统角色 1：管理员；2：健康管家")
    private Integer roleId;
    @ApiModelProperty(value = "页码")
    private Integer pageSize;
    @ApiModelProperty(value = "用户真实姓名")
    private String nickname;
    @ApiModelProperty(value = "关联系统健康管家(护工)  无管家设置  -1")
    private Integer userId;
    private Integer levelId;
}
