package himtiumt.co.id.himtiapps.authentication.ResetKataSandi.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseResetPassword{

	@SerializedName("message")
	private String message;

	@SerializedName("user")
	private User user;

	@SerializedName("status")
	private Boolean status;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setStatus(Boolean status){
		this.status = status;
	}

	public Boolean isStatus(){
		return status;
	}
}