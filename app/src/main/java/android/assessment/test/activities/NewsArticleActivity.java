package android.assessment.test.activities;


import android.arch.lifecycle.Observer;
import android.assessment.test.R;
import android.assessment.test.base.BaseActivity;
import android.assessment.test.databinding.ActivityNewsArticleBinding;
import android.assessment.test.enums.ViewModelEventsEnum;
import android.assessment.test.models.Movie;
import android.assessment.test.viewModels.NewsArticleViewModel;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.List;

public class NewsArticleActivity extends BaseActivity<NewsArticleViewModel, ActivityNewsArticleBinding> {

    @Override
    public Class<NewsArticleViewModel> getViewModel() {
        return NewsArticleViewModel.class;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_news_article;
    }

    @Override
    public void onObserve(ViewModelEventsEnum event, Object eventMessage) {
        super.onObserve(event, eventMessage);
        switch (event) {
            case NO_INTERNET_CONNECTION:
                onApiRequestFailed(getString(R.string.NO_INTERNET_CONNECTIVITY));
                break;
            case ON_NO_DATA_RECEIVED:
                onApiRequestFailed(eventMessage.toString());
                break;
            case ON_API_REQUEST_FAILURE:
                onApiRequestFailed(eventMessage.toString());
                break;
            case ON_API_CALL_START:
                showProgress();
                break;
            case ON_API_CALL_STOP:
                hideProgress();
                break;
            default:
                break;
        }
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, NewsArticleActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {

            }
        });
    }
}
