package himtiumt.co.id.himtiapps.sharing.model;

import com.google.gson.annotations.SerializedName;

public class JadwalItem{

	@SerializedName("image")
	private String image;

	@SerializedName("jadwal")
	private String jadwal;

	@SerializedName("id_kategori")
	private Integer idKategori;

	@SerializedName("updated_at")
	private Object updatedAt;

	@SerializedName("created_at")
	private Object createdAt;

	@SerializedName("id")
	private Integer id;

	@SerializedName("deskripsi")
	private String deskripsi;

	@SerializedName("tittle")
	private String tittle;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setJadwal(String jadwal){
		this.jadwal = jadwal;
	}

	public String getJadwal(){
		return jadwal;
	}

	public void setIdKategori(Integer idKategori){
		this.idKategori = idKategori;
	}

	public Integer getIdKategori(){
		return idKategori;
	}

	public void setUpdatedAt(Object updatedAt){
		this.updatedAt = updatedAt;
	}

	public Object getUpdatedAt(){
		return updatedAt;
	}

	public void setCreatedAt(Object createdAt){
		this.createdAt = createdAt;
	}

	public Object getCreatedAt(){
		return createdAt;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setDeskripsi(String deskripsi){
		this.deskripsi = deskripsi;
	}

	public String getDeskripsi(){
		return deskripsi;
	}

	public void setTittle(String tittle){
		this.tittle = tittle;
	}

	public String getTittle(){
		return tittle;
	}
}