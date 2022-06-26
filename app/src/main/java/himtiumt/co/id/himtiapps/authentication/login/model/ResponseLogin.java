package himtiumt.co.id.himtiapps.authentication.login.model;

import com.google.gson.annotations.SerializedName;

public class ResponseLogin{

	@SerializedName("dataLogin")
	private DataLogin dataLogin;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private Boolean status;

	public void setDataLogin(DataLogin dataLogin){
		this.dataLogin = dataLogin;
	}

	public DataLogin getDataLogin(){
		return dataLogin;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(Boolean status){
		this.status = status;
	}

	public Boolean isStatus(){
		return status;
	}
}