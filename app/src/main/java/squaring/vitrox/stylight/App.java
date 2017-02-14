package squaring.vitrox.stylight;

import android.app.Application;
import android.support.annotation.VisibleForTesting;

import squaring.vitrox.stylight.DependencyInjection.Component.AppComponent;
import squaring.vitrox.stylight.DependencyInjection.Component.DaggerAppComponent;
import squaring.vitrox.stylight.DependencyInjection.Module.ApplicationModule;


public class App extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    @VisibleForTesting
    public void setAppComponent(AppComponent appComponent) {
        mAppComponent = appComponent;
    }
}
