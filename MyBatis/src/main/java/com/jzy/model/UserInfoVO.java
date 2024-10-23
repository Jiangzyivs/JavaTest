package com.jzy.model;

import lombok.Data;

import java.math.BigInteger;

@Data
public class UserInfoVO {

    private int userId;

    private String name;

    private String phone;

    private Integer isDelete;

    private BigInteger createTime;

    private BigInteger modifyTime;

}
