package himtiumt.co.id.himtiapps.profile.Model;

import com.google.gson.annotations.SerializedName;

public class RequestProfile{

	@SerializedName("password")
	private String password;

	@SerializedName("no_hp")
	private String noHp;

	@SerializedName("name")
	private String name;

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

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}