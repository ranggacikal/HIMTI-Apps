package himtiumt.co.id.himtiapps.network;

import himtiumt.co.id.himtiapps.authentication.ResetKataSandi.Model.RequestResetPassword;
import himtiumt.co.id.himtiapps.authentication.ResetKataSandi.Model.ResponseResetPassword;
import himtiumt.co.id.himtiapps.authentication.login.model.RequestLogin;
import himtiumt.co.id.himtiapps.authentication.login.model.ResponseLogin;
import himtiumt.co.id.himtiapps.authentication.register.Model.RequestRegister;
import himtiumt.co.id.himtiapps.authentication.register.Model.ResponseRegister;
import himtiumt.co.id.himtiapps.model.ResponseAllDosen;
import himtiumt.co.id.himtiapps.model.ResponseDosen;
import himtiumt.co.id.himtiapps.sharing.model.ResponseDetailSharing;
import himtiumt.co.id.himtiapps.sharing.model.ResponseSharing;
import himtiumt.co.id.himtiapps.strukturOrganisasi.model.ResponseStrukturOrganisasi;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @POST("Api-login")
    Call<ResponseLogin> login(@Body RequestLogin requestLogin);

    @GET("Api-struktur-himti")
    Call<ResponseStrukturOrganisasi> getStrukturOrganisasi();

    @GET("Api-dosen")
    Call<ResponseAllDosen> AllDosen();

    @GET("Api-dosen-search")
    Call<ResponseDosen> getDosen (@Query("nama") String nama);

}
