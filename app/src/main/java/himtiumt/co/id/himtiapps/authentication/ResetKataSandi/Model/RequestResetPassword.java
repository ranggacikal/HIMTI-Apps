package himtiumt.co.id.himtiapps.authentication.ResetKataSandi.Model;

import com.google.gson.annotations.SerializedName;

public class RequestResetPassword{

	@SerializedName("password")
	private String password;

	@SerializedName("email")
	private String email;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}