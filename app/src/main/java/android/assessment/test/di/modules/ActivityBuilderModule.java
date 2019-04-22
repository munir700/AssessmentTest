package android.assessment.test.di.modules;



import android.assessment.test.activities.NewsArticleDetailsActivity;
import android.assessment.test.activities.NewsArticleActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract NewsArticleActivity newsArticleActivity();

    @ContributesAndroidInjector
    abstract NewsArticleDetailsActivity newArticleDetailsActivity();
}
