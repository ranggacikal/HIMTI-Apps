package himtiumt.co.id.himtiapps.network;

import himtiumt.co.id.himtiapps.authentication.login.model.RequestLogin;
import himtiumt.co.id.himtiapps.authentication.login.model.ResponseLogin;
import himtiumt.co.id.himtiapps.sharing.model.ResponseDetailSharing;
import himtiumt.co.id.himtiapps.sharing.model.ResponseSharing;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @POST("Api-login")
    Call<ResponseLogin> login(@Body RequestLogin requestLogin);

    @GET("Api-jadwal-saharing")
    Call<ResponseSharing> sharing();

    @GET("Api-detail-sharing/{id}")
    Call<ResponseDetailSharing> detailsharing(@Path("id")int id);

}
