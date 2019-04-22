package android.assessment.test.di.modules;

import android.app.Application;
import android.assessment.test.managers.AppManager;
import android.assessment.test.utils.NetworkUtils;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    AppManager providesAppManager(Application application) {
        AppManager appManager = new AppManager(application);
        return appManager;
    }


    @Provides
    @Singleton
    NetworkUtils providesNetworkUtils(Application application){
        NetworkUtils networkUtils = new NetworkUtils(application);
        return networkUtils;
    }
}
