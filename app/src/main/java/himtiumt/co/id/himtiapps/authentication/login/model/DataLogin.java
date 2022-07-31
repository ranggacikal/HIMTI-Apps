package himtiumt.co.id.himtiapps.authentication.login.model;

import com.google.gson.annotations.SerializedName;

public class DataLogin{

	@SerializedName("no_hp")
	private String noHp;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("verifikasi_password")
	private String verifikasiPassword;

	@SerializedName("name")
	private String name;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("email_verified_at")
	private Object emailVerifiedAt;

	@SerializedName("id")
	private Integer id;

	@SerializedName("email")
	private String email;

	public void setNoHp(String noHp){
		this.noHp = noHp;
	}

	public String getNoHp(){
		return noHp;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setVerifikasiPassword(String verifikasiPassword){
		this.verifikasiPassword = verifikasiPassword;
	}

	public String getVerifikasiPassword(){
		return verifikasiPassword;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setEmailVerifiedAt(Object emailVerifiedAt){
		this.emailVerifiedAt = emailVerifiedAt;
	}

	public Object getEmailVerifiedAt(){
		return emailVerifiedAt;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}