package com.course.modle.request;

import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户信息DTO")
public class UserInfoDTO {

    @NotNull(message = "用户账号不能为空")
    @ApiModelProperty("用户名")
    private String name;

    @NotNull(message = "用户账号不能为空")
    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("地址")
    private String address;

}
