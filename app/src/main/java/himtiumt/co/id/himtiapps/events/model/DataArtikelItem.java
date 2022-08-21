package himtiumt.co.id.himtiapps.events.model;

import com.google.gson.annotations.SerializedName;

public class DataArtikelItem{

	@SerializedName("image")
	private String image;

	@SerializedName("jadwal")
	private String jadwal;

	@SerializedName("id_kategori")
	private Integer idKategori;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("lokasi")
	private String lokasi;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private Integer id;

	@SerializedName("deskripsi")
	private String deskripsi;

	@SerializedName("Pengisi_acra")
	private String pengisiAcra;

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

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setLokasi(String lokasi){
		this.lokasi = lokasi;
	}

	public String getLokasi(){
		return lokasi;
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

	public void setDeskripsi(String deskripsi){
		this.deskripsi = deskripsi;
	}

	public String getDeskripsi(){
		return deskripsi;
	}

	public void setPengisiAcra(String pengisiAcra){
		this.pengisiAcra = pengisiAcra;
	}

	public String getPengisiAcra(){
		return pengisiAcra;
	}

	public void setTittle(String tittle){
		this.tittle = tittle;
	}

	public String getTittle(){
		return tittle;
	}
}