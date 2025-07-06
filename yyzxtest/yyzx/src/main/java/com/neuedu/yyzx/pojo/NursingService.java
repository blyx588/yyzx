package com.neuedu.yyzx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class NursingService {
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "编号")
    private String serialNumber;

    @ApiModelProperty(value = "名称")
    private String nursingName;

    @ApiModelProperty(value = "价格")
    private String servicePrice;

    @ApiModelProperty(value = "描述")
    private String message;

    @ApiModelProperty(value = "状态（1：启用；2：停用）")
    private Integer status;

    @ApiModelProperty(value = "执行周期")
    private String executionCycle;

    @ApiModelProperty(value = "执行次数")
    private String executionTimes;

    @ApiModelProperty(value = "逻辑删除标记（0：显示；1：隐藏）")
    private Integer isDeleted;


}
