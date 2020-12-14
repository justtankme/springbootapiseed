package com.company.project.test.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户基础信息表
 * </p>
 *
 * @author duanzhiwei
 * @since 2020-12-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_employee_copy1")
@ApiModel(value="EmployeeCopy1对象", description="用户基础信息表")
public class EmployeeCopy1 implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty(value = "用户名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty(value = "年龄")
    @TableField("user_age")
    private Integer userAge;

    @ApiModelProperty(value = "性别")
    @TableField("user_gender")
    private Integer userGender;

    @ApiModelProperty(value = "收入")
    @TableField("user_salary")
    private BigDecimal userSalary;

    @ApiModelProperty(value = "备注")
    @TableField("user_remark")
    private String userRemark;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建人")
    @TableField("create_user")
    private Integer createUser;

    @ApiModelProperty(value = "修改人")
    @TableField("update_user")
    private Integer updateUser;

    @ApiModelProperty(value = "是否逻辑删除")
    @TableField("deleted")
    private Integer deleted;

    @ApiModelProperty(value = "乐观锁")
    @TableField("version")
    private Integer version;


}
