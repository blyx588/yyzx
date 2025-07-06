package com.neuedu.yyzx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
@Data
@TableName("customernurseitem")
public class CustomerNurseItem {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Integer id;

    @TableField("item_id")
    @ApiModelProperty(value = "关联护理项目 ID")
    private Integer itemId;

    @TableField("customer_id")
    @ApiModelProperty(value = "客户 ID")
    private Integer customerId;

    @TableField("level_id")
    @ApiModelProperty(value = "关联护理级别 ID")
    private Integer levelId;

    @TableField("nurse_number")
    @ApiModelProperty(value = "购买数量")
    private Integer nurseNumber;

    @TableField("is_deleted")
    @ApiModelProperty(value = "逻辑删除标记（0：显示；1：隐藏）")
    private Integer isDeleted;

    @TableField("buy_time")
    @ApiModelProperty(value = "服务购买日期")
    private Date buyTime;

    @TableField("maturity_time")
    @ApiModelProperty(value = "服务到期日")
    private Date maturityTime;
}
