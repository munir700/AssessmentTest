package android.assessment.test.api;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class ResponseEnvelope<T> implements Serializable {

    @SerializedName("status")
    String status;
    @SerializedName("num_results")
    int  numResults;

    String[] errors;

    @SerializedName("results")
    T listItem;

    public static ExclusionStrategyResponse getExclusionStrategy(){
        return new ExclusionStrategyResponse();
    }

}


class ExclusionStrategyResponse implements ExclusionStrategy {

    public boolean shouldSkipClass(Class<?> arg0) {
        return false;
    }

    public boolean shouldSkipField(FieldAttributes f) {
        return ( f.getName().equals("response"));
    }
}