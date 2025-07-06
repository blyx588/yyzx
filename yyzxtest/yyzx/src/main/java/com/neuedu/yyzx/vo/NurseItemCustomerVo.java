package com.neuedu.yyzx.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = false)
public class NurseItemCustomerVo {
    private String customerName;
    private String itemName;
    private String itemId;
    private String servicePrice;
    private Integer serviceNumber;
    private Date buyTime;
    private Date maturityTime;
    private Integer isDeleted;
    private String serialNumber;
    private String nursingName;
    private Integer customerId;
 }
