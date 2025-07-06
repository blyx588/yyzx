package com.neuedu.yyzx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class LevelItem {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "关联护理级别 ID")
    private Integer levelId;

    @ApiModelProperty(value = "关联护理项目 ID")
    private Integer itemId;


}
