package com.health.system.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.health.common.annotation.Excel;
import com.health.common.core.domain.BaseEntity;

/**
 * 药品报销比例对象 insurance
 *
 *  
 * @date 2025-07-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Insurance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 报销比例 */
    @Excel(name = "报销比例")
    private Long reimbursementRate;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 说明 */
    @Excel(name = "说明")
    private String description;
}
