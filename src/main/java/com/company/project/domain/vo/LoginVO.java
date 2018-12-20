package com.company.project.domain.vo;

import com.alibaba.druid.support.json.JSONUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author duanzhiwei
 * 用户登录VO
 */
@ApiModel("用户登录信息")
public class LoginVO {
	@ApiModelProperty("用户名")
	private String userName;
	@ApiModelProperty("密码")
	private String pwd;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return JSONUtils.toJSONString(this);
	}
}
