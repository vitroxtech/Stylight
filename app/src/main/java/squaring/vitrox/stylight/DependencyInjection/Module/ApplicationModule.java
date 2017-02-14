package squaring.vitrox.stylight.DependencyInjection.Module;

import android.content.Context;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import squaring.vitrox.stylight.Adapter.ListAdapter;
import squaring.vitrox.stylight.App;

@Module
public class ApplicationModule {

    private final App mApp;

    public ApplicationModule(App app) {
        mApp = app;
    }

    @Provides
    @Singleton
    public Context appContext() {
        return mApp;
    }

    @Provides
    public ListAdapter listAdapter(Context context){return new ListAdapter(context);}
}
