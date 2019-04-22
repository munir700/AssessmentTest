package android.assessment.test.repositories;

import android.arch.lifecycle.MutableLiveData;
import android.assessment.test.BuildConfig;
import android.assessment.test.R;
import android.assessment.test.api.ApiService;
import android.assessment.test.base.BaseNetworkCallBack;
import android.assessment.test.base.BaseViewModel;
import android.assessment.test.enums.ViewModelEventsEnum;
import android.assessment.test.models.Movie;
import android.assessment.test.utils.NetworkUtils;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class MoviesRepository {

    @Inject
    ApiService apiService;


    @Inject
    NetworkUtils networkUtils;

    @Inject
    public MoviesRepository() {

    }

    public MutableLiveData<List<Movie>> getMoviesList(final BaseViewModel viewModel, Call<List<Movie>> listCall) {

        final MutableLiveData<List<Movie>> moviesLiveData = new MutableLiveData<>();
        if (networkUtils.isConnectedToInternet()) {
            if (listCall != null)
                listCall.cancel();

            listCall = apiService.getMovieList(550, BuildConfig.API_KEY, "en-US", 1);
            listCall.enqueue(new BaseNetworkCallBack<List<Movie>>(viewModel) {
                @Override
                public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                    super.onResponse(call, response);
                    if (!call.isCanceled() && response.isSuccessful()) {
                        moviesLiveData.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<List<Movie>> call, Throwable throwable) {
                    super.onFailure(call, throwable);
                }
            });

        } else {
            viewModel.notifyObserver(ViewModelEventsEnum.NO_INTERNET_CONNECTION, viewModel.getAppManager().getContext().getString(R.string.NO_INTERNET_CONNECTIVITY));
        }
        return moviesLiveData;
    }
}
