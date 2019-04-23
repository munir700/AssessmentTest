package android.assessment.test.activities;

import android.assessment.test.adapter.PhotoSliderAdapter;
import android.app.Activity;
import android.assessment.test.R;
import android.assessment.test.base.BaseActivity;
import android.assessment.test.databinding.ActivityNewsArticleDetailsBinding;
import android.assessment.test.models.Media;
import android.assessment.test.models.MediaMetadata;
import android.assessment.test.models.NewsArticle;
import android.assessment.test.viewModels.NewsArticleViewModel;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.view.View;

public class NewsArticleDetailsActivity extends BaseActivity<NewsArticleViewModel, ActivityNewsArticleDetailsBinding> implements PhotoSliderAdapter.OnClickListener {

    public static final int REQUEST_CODE = 100;
    public final static String LISTING_POSITION = "listing_index";
    public final static String NEWARTICLE_INFO_INTENT_KEY = "new_article";
    private PhotoSliderAdapter mySliderPagerAdapter;
    private NewsArticle newsArticle;

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

        Intent intent = new Intent(activity, NewsArticleDetailsActivity.class);
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
        newsArticle = getIntent().getParcelableExtra(NEWARTICLE_INFO_INTENT_KEY);
        binding.setNewArticle(newsArticle);
        setPhotoSlider(newsArticle);
    }


    private void setPhotoSlider(NewsArticle newsArticle) {
        Media media = newsArticle.getMedia() != null && newsArticle.getMedia().length > 0 ? newsArticle.getMedia()[0] : null;
        MediaMetadata[] mediaMetadata = media != null && media.getMediaMetadata() != null && media.getMediaMetadata().length > 0 ? media.getMediaMetadata() : new MediaMetadata[0];

        if (mySliderPagerAdapter == null) {
            mySliderPagerAdapter = new PhotoSliderAdapter(this, mediaMetadata, this);

            binding.viewPager.setAdapter(mySliderPagerAdapter);
            binding.viewPager.setOffscreenPageLimit(4);
        } else {
            mySliderPagerAdapter.setPhotos(mediaMetadata);
        }
        mySliderPagerAdapter.setPhotoSliderCallBackListener(new PhotoSliderAdapter.PhotoSliderCallBack() {
            @Override
            public void readyForTransition() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startPostponedEnterTransition();
                }
            }
        });
        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void onClose(View v) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_OK, returnIntent);
        super.onBackPressed();
    }


    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onItemClick(int position, View view) {

    }
}
