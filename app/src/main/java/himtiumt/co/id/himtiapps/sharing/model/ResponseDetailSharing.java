package himtiumt.co.id.himtiapps.sharing.model;

import com.google.gson.annotations.SerializedName;

public class ResponseDetailSharing{

	@SerializedName("Jadwal")
	private Jadwal jadwal;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private Boolean status;

	public void setJadwal(Jadwal jadwal){
		this.jadwal = jadwal;
	}

	public Jadwal getJadwal(){
		return jadwal;
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