package cn.com.weini.commons.pojo;

import java.io.Serializable;

public class GetNiSuOrderResultPO implements Serializable{
	private Boolean success;
	private String validate;
	private String message;
	private GetNiSuOrderResultDetailPO result;
	
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

	public GetNiSuOrderResultDetailPO getResult() {
		return result;
	}

	public void setResult(GetNiSuOrderResultDetailPO result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "GetNiSuOrderResultPO [success=" + success + ", validate=" + validate + ", message=" + message
				+ ", result=" + result + "]";
	}

	
}
