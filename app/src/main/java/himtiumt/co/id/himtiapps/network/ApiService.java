package himtiumt.co.id.himtiapps.network;

import himtiumt.co.id.himtiapps.authentication.login.model.RequestLogin;
import himtiumt.co.id.himtiapps.authentication.login.model.ResponseLogin;
import himtiumt.co.id.himtiapps.profile.model.RequestProfile;
import himtiumt.co.id.himtiapps.profile.model.ResponseProfile;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @POST("Api-login")
    Call<ResponseLogin> login(@Body RequestLogin requestLogin);

    @PATCH("Api-edit-profile/{id}")
    Call <ResponseProfile> getprofilebyid (@Path("id") int postid,
                                           @Body RequestProfile requestProfile);
}
