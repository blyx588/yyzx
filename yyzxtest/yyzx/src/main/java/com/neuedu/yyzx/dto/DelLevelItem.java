package com.neuedu.yyzx.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DelLevelItem {
    private Integer levelId;
    private Integer itemId;
}
