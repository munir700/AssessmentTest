package android.assessment.test.di.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.assessment.test.di.ViewModelKey;
import android.assessment.test.viewModels.NewsArticleViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(NewsArticleViewModel.class)
    abstract ViewModel bindMovieViewModel(NewsArticleViewModel newsArticleViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);

}
