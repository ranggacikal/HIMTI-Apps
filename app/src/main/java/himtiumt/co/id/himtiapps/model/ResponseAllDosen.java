package himtiumt.co.id.himtiapps.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseAllDosen{

	@SerializedName("Dosen")
	private List<DosenItem> dosen;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private Boolean status;

	public void setDosen(List<DosenItem> dosen){
		this.dosen = dosen;
	}

	public List<DosenItem> getDosen(){
		return dosen;
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