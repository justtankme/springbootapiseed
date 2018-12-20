package com.company.project.core.common;

/**
 * 
* @ClassName: ServiceException  
* @Description: 服务（业务）异常如“ 账号或密码错误 ”
* @author duanzhiwei
* @date 2018年1月16日 下午12:00:50  
*
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 6399275583396894983L;
    ResultCode resultCode = ResultCode.FAIL;
    Object data;
    public ServiceException() {
        super();
    }

    public ServiceException(Throwable e) {
        super(e);
    }

    public ServiceException(ResultCode resultCode) {
        super("");
        this.resultCode = resultCode;
    }

    public ServiceException(String message, Throwable e) {
        super(message, e);
    }

    public ServiceException(ResultCode resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }
    
    public ServiceException(ResultCode resultCode, Object data) {
        this.resultCode = resultCode;
        this.data=data;
    }
    
    public ServiceException(ResultCode resultCode, String message,Object data) {
        super(message);
        this.resultCode = resultCode;
        this.data=data;
    }
    
    public ServiceException(ResultCode resultCode, String message, Throwable e,Object data) {
        super(message, e);
        this.resultCode = resultCode;
        this.data=data;
    }

	public ResultCode getResultCode() {
		return resultCode;
	}

	public void setResultCode(ResultCode resultCode) {
		this.resultCode = resultCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
    
}
