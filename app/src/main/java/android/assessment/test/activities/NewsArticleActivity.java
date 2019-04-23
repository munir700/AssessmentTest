package android.assessment.test.activities;


import android.arch.lifecycle.Observer;
import android.assessment.test.R;
import android.assessment.test.adapter.ListingAdapter;
import android.assessment.test.base.BaseActivity;
import android.assessment.test.databinding.ActivityNewsArticleBinding;
import android.assessment.test.databinding.RowListingsBinding;
import android.assessment.test.enums.ErrorResponseEnum;
import android.assessment.test.enums.ViewModelEventsEnum;
import android.assessment.test.models.NewsArticle;
import android.assessment.test.utils.ErrorResponse;
import android.assessment.test.viewModels.NewsArticleViewModel;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static android.assessment.test.activities.NewsArticleDetailsActivity.REQUEST_CODE;


public class NewsArticleActivity extends BaseActivity<NewsArticleViewModel, ActivityNewsArticleBinding> {

    private int defaultPeriod = 7;

    private ListingAdapter listingAdapter;

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
                binding.pullToRefresh.setVisibility(View.GONE);
                binding.constraintError.setVisibility(View.VISIBLE);
                viewModel.setErrorResponse(new ErrorResponse.Builder(ErrorResponseEnum.NO_INTERNET_CONNECTION).build());
                hideProgress();
                break;
            case ON_NO_DATA_RECEIVED:
                if (eventMessage != null) {
                    onApiRequestFailed(eventMessage.toString());
                }
                binding.pullToRefresh.setVisibility(View.GONE);
                binding.constraintError.setVisibility(View.VISIBLE);
                viewModel.newsArticle.setValue(new ArrayList<NewsArticle>());
                listingAdapter.setData(new ArrayList<NewsArticle>());
                viewModel.setErrorResponse(new ErrorResponse.Builder(ErrorResponseEnum.NO_DATA_RECEIVED).build());
                break;
            case ON_API_REQUEST_FAILURE:
                binding.constraintError.setVisibility(View.VISIBLE);
                viewModel.setErrorResponse(new ErrorResponse.Builder(ErrorResponseEnum.API_REQUEST_FAILURE).build());
                break;
            case ON_API_CALL_START:
                binding.pullToRefresh.setVisibility(View.VISIBLE);
                binding.constraintError.setVisibility(View.GONE);
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
        binding.setVm(viewModel);
        initUI();
        loadNewsArticles(defaultPeriod);
    }


    private void initUI() {

        try {
            ((SimpleItemAnimator) binding.recyclerResults.getItemAnimator()).setSupportsChangeAnimations(false);
            listingAdapter = new ListingAdapter(NewsArticleActivity.this, viewModel.getAppManager(), viewModel.newsArticle, new ListingAdapter.OnClickListener() {
                @Override
                public void onItemClick(int position, NewsArticle newsArticle, RowListingsBinding binding) {
                    NewsArticleDetailsActivity.openActivityForResult(NewsArticleActivity.this, newsArticle, binding.thumbIv, REQUEST_CODE, position);
                }
            });

            binding.recyclerResults.setAdapter(listingAdapter);


            binding.searchAgainBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadNewsArticles(getInputPeriod());
                }
            });

            binding.pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    binding.pullToRefresh.setRefreshing(false);
                    loadNewsArticles(getInputPeriod());
                }
            });

            binding.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadNewsArticles(getInputPeriod());
                }
            });
        } catch (Exception e) {
            Log.e("Exception", "Error while initialize UI components and message =" + e.getMessage());
        }

    }

    private int getInputPeriod() {
        String period = binding.periodEt.getText().toString();
        if (period.isEmpty())
            return defaultPeriod;
        else
            return Integer.valueOf(period);

    }

    private void loadNewsArticles(int newsArticlePeriod) {
        viewModel.getMostViewedNYTimePopularArticles(newsArticlePeriod).observe(this, new Observer<List<NewsArticle>>() {
            @Override
            public void onChanged(@Nullable List<NewsArticle> newsArticles) {
                listingAdapter.setData(newsArticles);
            }
        });
    }

}
