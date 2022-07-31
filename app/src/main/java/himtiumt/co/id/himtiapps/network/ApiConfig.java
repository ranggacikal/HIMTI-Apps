package himtiumt.co.id.himtiapps.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {

    private static OkHttpClient getLogging(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return new OkHttpClient.Builder()
                            .addInterceptor(logging)
                            .build();
    }

    private static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("http://web-api.himtiumt.org/api/")
                .client(getLogging())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService service = getRetrofit().create(ApiService.class);

}