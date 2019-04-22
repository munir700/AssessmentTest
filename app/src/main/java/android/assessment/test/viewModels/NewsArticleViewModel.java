package android.assessment.test.viewModels;

import android.arch.lifecycle.MutableLiveData;

import android.assessment.test.base.BaseViewModel;
import android.assessment.test.models.Movie;
import android.assessment.test.repositories.MoviesRepository;
import android.assessment.test.utils.ErrorResponse;
import android.databinding.Bindable;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

public class NewsArticleViewModel extends BaseViewModel {

    private ErrorResponse errorResponse;
    Call<List<Movie>> listCall;

    @Inject
    MoviesRepository moviesRepository;

    @Inject
    public NewsArticleViewModel() {

    }


    @Bindable
    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
        //notifyPropertyChanged(BR.errorResponse);
    }

    public MutableLiveData<List<Movie>> getMovies() {
        return moviesRepository.getMoviesList(this, listCall);
    }
}
