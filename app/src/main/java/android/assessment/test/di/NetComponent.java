package android.assessment.test.di;


import android.app.Application;
import android.assessment.test.AppApplication;
import android.assessment.test.di.modules.ActivityBuilderModule;
import android.assessment.test.di.modules.ApiClientModule;
import android.assessment.test.di.modules.AppModule;
import android.assessment.test.di.modules.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AppModule.class,
        ApiClientModule.class,
        AndroidInjectionModule.class,
        ActivityBuilderModule.class,
        AndroidSupportInjectionModule.class,
        ViewModelModule.class

})
public interface NetComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        NetComponent build();
    }

    void inject(AppApplication app);
}