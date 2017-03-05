package me.king.admin.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class BusinessExecutionResult {
	private static final String SUCCESS = "10000";
	private static final String ERROR_PARAM = "20000";
	private static final String ILLEGAL_OPERATION = "30000";
	private String code;
	private String message;
	private Object data;
	public static BusinessExecutionResult success() {
		return new BusinessExecutionResult(BusinessExecutionResult.SUCCESS, null, null);
	}
	public static BusinessExecutionResult success(Object data){
		return new BusinessExecutionResult(BusinessExecutionResult.SUCCESS, null, data);
	}
	public static BusinessExecutionResult success(String message,Object data){
		return new BusinessExecutionResult(BusinessExecutionResult.SUCCESS, message, data);
	}
	public static BusinessExecutionResult illegalOperation(String message,Object data){
		return new BusinessExecutionResult(BusinessExecutionResult.ILLEGAL_OPERATION, message, data);
	}
	public static BusinessExecutionResult illegalOperation(String message){
		return new BusinessExecutionResult(BusinessExecutionResult.ILLEGAL_OPERATION, message, null);
	}
	public static BusinessExecutionResult paramError(String message,Object data){
		return new BusinessExecutionResult(BusinessExecutionResult.ERROR_PARAM, message, data);
	}
	public static BusinessExecutionResult paramError(String message){
		return new BusinessExecutionResult(BusinessExecutionResult.ERROR_PARAM, message, null);
	}
	public BusinessExecutionResult(String code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
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
