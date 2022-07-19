package himtiumt.co.id.himtiapps.network;

import himtiumt.co.id.himtiapps.authentication.login.model.RequestLogin;
import himtiumt.co.id.himtiapps.authentication.login.model.ResponseLogin;
import himtiumt.co.id.himtiapps.strukturOrganisasi.model.ResponseStrukturOrganisasi;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("Api-login")
    Call<ResponseLogin> login(@Body RequestLogin requestLogin);
    @GET("Api-struktur-himti")
    Call<ResponseStrukturOrganisasi> getStrukturOrganisasi();

}
