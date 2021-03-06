package android.assessment.test.viewModels;

import android.arch.lifecycle.MutableLiveData;

import android.assessment.test.BR;
import android.assessment.test.base.BaseViewModel;
import android.assessment.test.models.NewsArticle;
import android.assessment.test.repositories.NewsArticleRepository;
import android.assessment.test.utils.ErrorResponse;
import android.databinding.Bindable;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

public class NewsArticleViewModel extends BaseViewModel {
    public MutableLiveData<List<NewsArticle>> newsArticle = new MutableLiveData<>();

    private ErrorResponse errorResponse;
    Call<List<NewsArticle>> listCall;

    @Inject
    NewsArticleRepository moviesRepository;

    @Inject
    public NewsArticleViewModel() {

    }


    @Bindable
    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
        notifyPropertyChanged(BR.errorResponse);
    }

    public MutableLiveData<List<NewsArticle>> getMostViewedNYTimePopularArticles(int newsArticlePeriod) {
        return newsArticle = moviesRepository.getMostViewedNYTimePopularArticles(this, listCall, newsArticlePeriod);
    }

    public boolean isLoading(){
        return false;
    }
}
