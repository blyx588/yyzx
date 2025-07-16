package com.health.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("patient")
public class Patient {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String hospitalNo;
    private String name;
    private String idCard;
    private Integer age;
    private Date birthDate;
    private String gender;
    private String address;
    private String settlementType;
    private String workStatus;
    private LocalDateTime admissionTime;
    private LocalDateTime registerTime;
    private Integer status;
}
