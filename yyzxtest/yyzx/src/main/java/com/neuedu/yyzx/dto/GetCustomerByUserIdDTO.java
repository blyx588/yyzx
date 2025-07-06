package com.neuedu.yyzx.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class GetCustomerByUserIdDTO {
    private Integer userId;
    private Integer pageSize;
}
