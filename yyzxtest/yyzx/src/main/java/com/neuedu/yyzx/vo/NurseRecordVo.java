package com.neuedu.yyzx.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
public class NurseRecordVo {
    private Integer id;
    private String customerName;
    private String itemName;
    private Integer itemId;
    private String servicePrice;
    private Integer serviceNumber;
    private Date nursingTime;
    private Integer isDeleted;
    private String serialNumber;
    private String nursingName;
    private Integer customerId;
    private String userName;
    private String nursingContent;
    private String phoneNumber;

}
