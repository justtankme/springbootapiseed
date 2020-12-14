package com.company.project.test.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.Instant;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author duanzhiwei
 * @since 2020-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TUser对象", description="")
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID", example = "1234566")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty(value = "用户名称", example = "1234566")
    private String userName;

    private Integer userAge;

    private Integer userGender;

    private BigDecimal userSalary;

    private String userRemark;

    //前台向后台传递字符串类型的日期参数时，需要通过此注解将字符串解析成日期类型，其中日期格式可以根据需要进行设置。
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss:SSSSSSSSS")
    //SpringMVC向前端返回json格式的数据时，日期类型默认返回时间戳，那么我们可以通过此注解将时间返回为固定格式的字符串。
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss:SSSSSSSSS",timezone = "GMT+8")
    private LocalDateTime createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss:SSSSSS")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss:SSSSSS",timezone = "GMT+8")
    private LocalDateTime updateTime;


}
