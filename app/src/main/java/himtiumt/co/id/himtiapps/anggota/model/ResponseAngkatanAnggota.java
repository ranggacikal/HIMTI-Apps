package himtiumt.co.id.himtiapps.anggota.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseAngkatanAnggota{

	@SerializedName("Anggota")
	private List<AnggotaItem> anggota;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private Boolean status;

	public void setAnggota(List<AnggotaItem> anggota){
		this.anggota = anggota;
	}

	public List<AnggotaItem> getAnggota(){
		return anggota;
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