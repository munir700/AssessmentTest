package android.assessment.test.activities;

import android.app.Activity;
import android.assessment.test.R;
import android.assessment.test.base.BaseActivity;
import android.assessment.test.databinding.ActivityNewsArticleDetailsBinding;
import android.assessment.test.models.NewsArticle;
import android.assessment.test.viewModels.NewsArticleViewModel;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;

public class NewArticleDetailsActivity extends BaseActivity<NewsArticleViewModel, ActivityNewsArticleDetailsBinding> {

    public static final int REQUEST_CODE = 100;
    public final static String LISTING_POSITION = "listing_index";
    public final static String NEWARTICLE_INFO_INTENT_KEY = "new_article";

    @Override
    public Class<NewsArticleViewModel> getViewModel() {
        return NewsArticleViewModel.class;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_news_article_details;
    }


    public static void openActivityForResult(Activity activity,
                                             NewsArticle newsArticle,
                                             final View thumb, int requestCode, int listingPosition) {

        Intent intent = new Intent(activity, NewArticleDetailsActivity.class);
        intent.putExtra(NEWARTICLE_INFO_INTENT_KEY, newsArticle);
        intent.putExtra(LISTING_POSITION, listingPosition);
        if (thumb != null) {
            Pair<View, String> p1;
            ActivityOptionsCompat options;

            p1 = Pair.create(thumb, activity.getResources()
                    .getString(R.string.STR_NEWS_DETAILS_TRANSITION));
            options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                    p1);

            activity.startActivityForResult(intent, requestCode, options.toBundle());
        } else {
            activity.startActivityForResult(intent, requestCode);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
