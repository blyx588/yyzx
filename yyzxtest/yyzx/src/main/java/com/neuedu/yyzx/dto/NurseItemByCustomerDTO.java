package com.neuedu.yyzx.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NurseItemByCustomerDTO {
    private Integer pageSize;
    private Integer customerId;
    private Integer itemId;
}
