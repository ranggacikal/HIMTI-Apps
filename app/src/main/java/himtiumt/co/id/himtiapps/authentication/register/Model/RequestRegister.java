package himtiumt.co.id.himtiapps.authentication.register.Model;

import com.google.gson.annotations.SerializedName;

public class RequestRegister{

	@SerializedName("password")
	private String password;

	@SerializedName("no_hp")
	private String noHp;

	@SerializedName("verifikasi_password")
	private String verifikasiPassword;

	@SerializedName("name")
	private String name;

	@SerializedName("email")
	private String email;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setNoHp(String noHp){
		this.noHp = noHp;
	}

	public String getNoHp(){
		return noHp;
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

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}