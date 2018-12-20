package com.company.project.core.exception;

import com.company.project.core.common.ResultCode;
import com.company.project.core.common.ServiceException;

/**
 * 
* @ClassName: UserNamePwdErrException  
* @Description: 用户名或密码错误
* @author duanzhiwei
* @date 2018年1月16日 上午11:29:29  
*
 */
public class UserNamePwdErrException extends ServiceException{
	private static final long serialVersionUID = 1L;
    
    /**
     * resultCode:异常状态码及异常信息
     */
    private static ResultCode resultCode = ResultCode.USER_LOGIN_FAILED_NAMEPWDERR;
    
    public UserNamePwdErrException(){
    	super(resultCode);
    }
    
    public UserNamePwdErrException(Object data){
        super(resultCode, data);
    }
}
