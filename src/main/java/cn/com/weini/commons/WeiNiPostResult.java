package cn.com.weini.commons;

import java.io.Serializable;


public class WeiNiPostResult implements Serializable{
	private Boolean success;
	private String validate;
	private String message;
	private GetNiSuOrderResultDetailPO result;
	
	public GetNiSuOrderResultDetailPO getResult() {
		return result;
	}

	public void setResult(GetNiSuOrderResultDetailPO result) {
		this.result = result;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "WeiNiPostResult [success=" + success + ", validate=" + validate + ", message=" + message + ", result="
				+ result + "]";
	}

	
	
	
	
}
