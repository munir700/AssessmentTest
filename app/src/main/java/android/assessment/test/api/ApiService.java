package android.assessment.test.api;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("mostviewed/{section}/{period}/json")
    Call<List<Object>> getMostViewedNYTimePopularArticles(@Path("section") int section, @Path("period") int period, @Query("api_key") String apiKey);


    @GET("mostviewed/{section}/{period}/json")
    Call<Object> getMostViewedNYTimePopularArticle(@Path("section") String section, @Path("period") int period, @Field("api_key") String apiKey);


}
