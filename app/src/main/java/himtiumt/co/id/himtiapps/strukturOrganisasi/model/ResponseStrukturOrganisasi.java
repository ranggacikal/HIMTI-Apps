package himtiumt.co.id.himtiapps.strukturOrganisasi.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseStrukturOrganisasi{

	@SerializedName("Pengurus")
	private List<PengurusItem> pengurus;

	@SerializedName("massege")
	private String massege;

	@SerializedName("status")
	private Boolean status;

	public void setPengurus(List<PengurusItem> pengurus){
		this.pengurus = pengurus;
	}

	public List<PengurusItem> getPengurus(){
		return pengurus;
	}

	public void setMassege(String massege){
		this.massege = massege;
	}

	public String getMassege(){
		return massege;
	}

	public void setStatus(Boolean status){
		this.status = status;
	}

	public Boolean isStatus(){
		return status;
	}
}