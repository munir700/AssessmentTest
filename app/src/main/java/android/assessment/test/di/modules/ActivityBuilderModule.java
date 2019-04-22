package android.assessment.test.di.modules;



import android.assessment.test.activities.MoviesActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract MoviesActivity mortgageActivity();
}
