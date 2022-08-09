package himtiumt.co.id.himtiapps.events.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseEvent{

	@SerializedName("data artikel")
	private List<DataArtikelItem> dataArtikel;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private Boolean status;

	public void setDataArtikel(List<DataArtikelItem> dataArtikel){
		this.dataArtikel = dataArtikel;
	}

	public List<DataArtikelItem> getDataArtikel(){
		return dataArtikel;
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