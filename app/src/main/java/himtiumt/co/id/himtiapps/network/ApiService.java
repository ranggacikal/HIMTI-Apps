package himtiumt.co.id.himtiapps.network;

import himtiumt.co.id.himtiapps.anggota.model.ResponseAnggotaAll;
import himtiumt.co.id.himtiapps.anggota.model.ResponseAngkatanAnggota;
import himtiumt.co.id.himtiapps.anggota.model.ResponseSearchAnggota;
import himtiumt.co.id.himtiapps.authentication.ResetKataSandi.Model.RequestResetPassword;
import himtiumt.co.id.himtiapps.authentication.ResetKataSandi.Model.ResponseResetPassword;
import himtiumt.co.id.himtiapps.authentication.login.model.RequestLogin;
import himtiumt.co.id.himtiapps.authentication.login.model.ResponseLogin;
import himtiumt.co.id.himtiapps.strukturOrganisasi.model.ResponseStrukturOrganisasi;
import himtiumt.co.id.himtiapps.sharing.model.ResponseDetailSharing;
import himtiumt.co.id.himtiapps.sharing.model.ResponseSharing;
import himtiumt.co.id.himtiapps.authentication.register.Model.RequestRegister;
import himtiumt.co.id.himtiapps.authentication.register.Model.ResponseRegister;
import himtiumt.co.id.himtiapps.profile.Model.RequestProfile;
import himtiumt.co.id.himtiapps.profile.Model.ResponseProfile;
import himtiumt.co.id.himtiapps.model.ResponseAllDosen;
import himtiumt.co.id.himtiapps.model.ResponseDosen;
import himtiumt.co.id.himtiapps.sharing.model.ResponseDetailSharing;
import himtiumt.co.id.himtiapps.sharing.model.ResponseSharing;
import himtiumt.co.id.himtiapps.strukturOrganisasi.model.ResponseStrukturOrganisasi;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Path;

public interface ApiService {

    @POST("Api-login")
    Call<ResponseLogin> login(@Body RequestLogin requestLogin);

    @GET("Api-struktur-himti")
    Call<ResponseStrukturOrganisasi> getStrukturOrganisasi();

    @GET("Api-dosen")
    Call<ResponseAllDosen> AllDosen();
    @GET("Api-jadwal-saharing")
    Call<ResponseSharing> sharing();

    @GET("Api-dosen-search")
    Call<ResponseDosen> getDosen (@Query("nama") String nama);
    @GET("Api-detail-sharing/{id}")
    Call<ResponseDetailSharing> detailsharing(@Path("id")int id);

    @POST("Api-registrasi")
    Call<ResponseRegister> register(@Body RequestRegister requestRegister);

    @POST("Api-LupaPassword")
    Call<ResponseResetPassword> resetpassword(@Body RequestResetPassword requestResetPassword);

    @PATCH("Api-edit-profile/{id}")
    Call <ResponseProfile> getprofilebyid (@Path("id") int postid,
                                           @Body RequestProfile requestProfile);

    @GET("Api-anggota-all")
    Call<ResponseAnggotaAll> getAnggotaAll();

    @FormUrlEncoded
    @POST("Api-angkatan-anggota")
    Call<ResponseAngkatanAnggota> getAngkatanAnggota(@Field("angkatan") String angkatan);

    @GET("Api-search-anggota")
    Call<ResponseSearchAnggota> getSearchAnggota(@Query("anggota") String anggota);

}
