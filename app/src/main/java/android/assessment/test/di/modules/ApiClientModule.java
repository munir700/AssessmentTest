package android.assessment.test.di.modules;

import android.assessment.test.api.ApiConverterFactory;
import android.assessment.test.api.ApiHttpClient;
import android.assessment.test.api.ApiService;
import android.assessment.test.utils.ApiUtils;

import java.util.HashMap;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiClientModule {
    @Provides
    @Singleton
    public ApiService getApiService() {

        Retrofit apiClient = new Retrofit.Builder()
                .baseUrl(ApiUtils.getApiBaseUrl())
                .addConverterFactory(new ApiConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .client(new ApiHttpClient().getHTTPClient(new HashMap<String, String>()))
                .build();
        return apiClient.create(ApiService.class);

    }

}
