package android.assessment.test.base;


import android.assessment.test.enums.ViewModelEventsEnum;
import android.assessment.test.interfaces.ViewModelCallBackObserver;
import android.assessment.test.managers.AppManager;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by Munir Ahmad.
 */

public class BaseViewModel extends ObservableViewModel {

    @Inject
    protected AppManager appManager;

    private ArrayList<ViewModelCallBackObserver> callBacksObservers = new ArrayList<>();

    public void addObserver(ViewModelCallBackObserver callBackObserver) {
        this.callBacksObservers.add(callBackObserver);
    }

    public void notifyObserver(ViewModelEventsEnum eventType, Object message) {
        for (ViewModelCallBackObserver callBackObserver : callBacksObservers) {
            callBackObserver.onObserve(eventType, message);
        }
    }

    public void removeCallBacks() {
        callBacksObservers.clear();
    }

    public AppManager getAppManager() {
        return appManager;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        removeCallBacks();
    }

}
