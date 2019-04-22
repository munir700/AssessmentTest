package android.assessment.test.repositories;

import android.arch.lifecycle.MutableLiveData;
import android.assessment.test.BuildConfig;
import android.assessment.test.R;
import android.assessment.test.api.ApiService;
import android.assessment.test.base.BaseNetworkCallBack;
import android.assessment.test.base.BaseViewModel;
import android.assessment.test.enums.ViewModelEventsEnum;
import android.assessment.test.models.NewsArticle;
import android.assessment.test.utils.NetworkUtils;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class NewsArticleRepository {

    @Inject
    ApiService apiService;


    @Inject
    NetworkUtils networkUtils;

    @Inject
    public NewsArticleRepository() {

    }

    public MutableLiveData<List<NewsArticle>> getMostViewedNYTimePopularArticles(final BaseViewModel viewModel, Call<List<NewsArticle>> listCall) {

        final MutableLiveData<List<NewsArticle>> moviesLiveData = new MutableLiveData<>();
        if (networkUtils.isConnectedToInternet()) {
            if (listCall != null)
                listCall.cancel();

            listCall = apiService.getMostViewedNYTimePopularArticles("all-sections", 7, BuildConfig.API_KEY);
            listCall.enqueue(new BaseNetworkCallBack<List<NewsArticle>>(viewModel) {
                @Override
                public void onResponse(Call<List<NewsArticle>> call, Response<List<NewsArticle>> response) {
                    super.onResponse(call, response);
                    if (!call.isCanceled() && response.isSuccessful()) {
                        moviesLiveData.postValue(response.body());
                    }else {
                        viewModel.notifyObserver(ViewModelEventsEnum.ON_NO_DATA_RECEIVED, response.message());
                    }
                }

                @Override
                public void onFailure(Call<List<NewsArticle>> call, Throwable throwable) {
                    super.onFailure(call, throwable);
                }
            });

        } else {
            viewModel.notifyObserver(ViewModelEventsEnum.NO_INTERNET_CONNECTION, viewModel.getAppManager().getContext().getString(R.string.NO_INTERNET_CONNECTIVITY));
        }
        return moviesLiveData;
    }
}
