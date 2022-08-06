package himtiumt.co.id.himtiapps.events.model;

import com.google.gson.annotations.SerializedName;

public class ResponseDetailEvent{

	@SerializedName("data artikel")
	private DataArtikel dataArtikel;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private Boolean status;

	public void setDataArtikel(DataArtikel dataArtikel){
		this.dataArtikel = dataArtikel;
	}

	public DataArtikel getDataArtikel(){
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