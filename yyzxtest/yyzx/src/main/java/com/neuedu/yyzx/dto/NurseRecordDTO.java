package com.neuedu.yyzx.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NurseRecordDTO {
    private Integer PageSize;
    private Integer customerId;
    private Integer id;
}
