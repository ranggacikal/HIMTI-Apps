package himtiumt.co.id.himtiapps.sharing.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseSharing{

	@SerializedName("Jadwal")
	private List<JadwalItem> jadwal;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private Boolean status;

	public void setJadwal(List<JadwalItem> jadwal){
		this.jadwal = jadwal;
	}

	public List<JadwalItem> getJadwal(){
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