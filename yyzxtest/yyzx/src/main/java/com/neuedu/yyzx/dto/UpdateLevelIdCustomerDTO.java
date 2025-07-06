package com.neuedu.yyzx.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateLevelIdCustomerDTO {
    private Integer id;
    private Integer levelId;
}
