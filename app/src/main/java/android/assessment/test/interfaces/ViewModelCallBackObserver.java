package android.assessment.test.interfaces;


import android.assessment.test.enums.ViewModelEventsEnum;

public interface ViewModelCallBackObserver<T> {

    void onObserve(ViewModelEventsEnum event, T eventMessage);

}
