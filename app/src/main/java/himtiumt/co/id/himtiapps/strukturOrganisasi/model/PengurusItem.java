package himtiumt.co.id.himtiapps.strukturOrganisasi.model;

import com.google.gson.annotations.SerializedName;

public class PengurusItem{

	@SerializedName("nim")
	private String nim;

	@SerializedName("id_angkatan")
	private Integer idAngkatan;

	@SerializedName("nama")
	private String nama;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("jabatan")
	private String jabatan;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private Integer id;

	@SerializedName("status")
	private String status;

	public void setNim(String nim){
		this.nim = nim;
	}

	public String getNim(){
		return nim;
	}

	public void setIdAngkatan(Integer idAngkatan){
		this.idAngkatan = idAngkatan;
	}

	public Integer getIdAngkatan(){
		return idAngkatan;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setJabatan(String jabatan){
		this.jabatan = jabatan;
	}

	public String getJabatan(){
		return jabatan;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}