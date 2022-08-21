package himtiumt.co.id.himtiapps.anggota.model;

import com.google.gson.annotations.SerializedName;

public class AnggotaItem{

	@SerializedName("nim")
	private String nim;

	@SerializedName("nama")
	private String nama;

	@SerializedName("no_hp")
	private String noHp;

	@SerializedName("angkatan")
	private Integer angkatan;

	@SerializedName("email")
	private String email;

	public void setNim(String nim){
		this.nim = nim;
	}

	public String getNim(){
		return nim;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setNoHp(String noHp){
		this.noHp = noHp;
	}

	public String getNoHp(){
		return noHp;
	}

	public void setAngkatan(Integer angkatan){
		this.angkatan = angkatan;
	}

	public Integer getAngkatan(){
		return angkatan;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}