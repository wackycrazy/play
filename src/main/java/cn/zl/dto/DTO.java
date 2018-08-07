package cn.zl.dto;

public class DTO {

	/**
	 * 状态码：1代表成功，2代表异常
	 */
	public String code = "1";
	
	//成功或者异常信息
	public String message = "success";
	
	//数据体
	public Object data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
