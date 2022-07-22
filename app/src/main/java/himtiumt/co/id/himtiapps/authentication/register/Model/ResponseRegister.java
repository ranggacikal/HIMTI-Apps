package himtiumt.co.id.himtiapps.authentication.register.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseRegister{

	@SerializedName("user")
	private User user;

	@SerializedName("status")
	private Boolean status;

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