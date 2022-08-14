package himtiumt.co.id.himtiapps.profile.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseProfile{

	@SerializedName("profilUpdate")
	private ProfilUpdate profilUpdate;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private Boolean status;

	public void setProfilUpdate(ProfilUpdate profilUpdate){
		this.profilUpdate = profilUpdate;
	}

	public ProfilUpdate getProfilUpdate(){
		return profilUpdate;
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