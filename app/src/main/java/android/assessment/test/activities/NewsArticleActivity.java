package android.assessment.test.activities;


import android.arch.lifecycle.Observer;
import android.assessment.test.R;
import android.assessment.test.adapter.ListingAdapter;
import android.assessment.test.base.BaseActivity;
import android.assessment.test.databinding.ActivityNewsArticleBinding;
import android.assessment.test.databinding.RowListingsBinding;
import android.assessment.test.enums.ViewModelEventsEnum;
import android.assessment.test.models.NewsArticle;
import android.assessment.test.viewModels.NewsArticleViewModel;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;

import java.util.List;

import static java.security.AccessController.getContext;

public class NewsArticleActivity extends BaseActivity<NewsArticleViewModel, ActivityNewsArticleBinding> {

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
        initUI();
        viewModel.getMostViewedNYTimePopularArticles().observe(this, new Observer<List<NewsArticle>>() {
            @Override
            public void onChanged(@Nullable List<NewsArticle> newsArticles) {
                listingAdapter.setData(newsArticles);
            }
        });
    }


    private void initUI() {

        try {

            ((SimpleItemAnimator) binding.recyclerResults.getItemAnimator()).setSupportsChangeAnimations(false);
            listingAdapter = new ListingAdapter(NewsArticleActivity.this, viewModel.getAppManager(), viewModel.newsArticle, new ListingAdapter.OnClickListener() {


                @Override
                public void onItemClick(int position, NewsArticle newsArticle, RowListingsBinding binding) {

                }


            });

            binding.recyclerResults.setAdapter(listingAdapter);
         /*   scrollListener = new EndlessRecyclerViewScrollListener((LinearLayoutManager)  binding.mainContents.recyclerResults.getLayoutManager()) {
                @Override
                public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                    if (!viewModel.isLastPageLoaded()) {
                        processNextRequest();
                        listingAdapter.setFooterVisibility(View.VISIBLE);
                    } else {
                        listingAdapter.setFooterVisibility(View.GONE);
                    }

                }
            };

            binding.mainContents.recyclerResults.addOnScrollListener(scrollListener);
            binding.mainContents.pullToRefresh.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    reintiateRequest();
                }
            });*/

        } catch (Exception e) {
            Log.e("Exception", "Error while initialize UI components and message =" + e.getMessage());
        }

    }

}
