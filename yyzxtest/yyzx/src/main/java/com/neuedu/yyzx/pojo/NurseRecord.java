package com.neuedu.yyzx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@TableName("nurserecord")
public class NurseRecord {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Integer id;

    @TableField("is_deleted")
    @ApiModelProperty(value = "逻辑删除标记（0：显示；1：隐藏）")
    private Integer isDeleted;

    @TableField("customer_id")
    @ApiModelProperty(value = "客户 ID")
    private Integer customerId;

    @TableField("item_id")
    @ApiModelProperty(value = "关联护理项目 ID")
    private Integer itemId;

    @TableField("nursing_time")
    @ApiModelProperty(value = "护理时间")
    private Date nursingTime;

    @TableField("nursing_content")
    @ApiModelProperty(value = "护理内容")
    private String nursingContent;

    @TableField("nursing_count")
    @ApiModelProperty(value = "护理数量")
    private Integer nursingCount;

    @TableField("user_id")
    @ApiModelProperty(value = "护理人员 ID")
    private Integer userId;
}
