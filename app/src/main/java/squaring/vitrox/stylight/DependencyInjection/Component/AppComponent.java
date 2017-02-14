package squaring.vitrox.stylight.DependencyInjection.Component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import squaring.vitrox.stylight.Adapter.ListAdapter;
import squaring.vitrox.stylight.DependencyInjection.Module.ApplicationModule;
import squaring.vitrox.stylight.Network.ApiService;
import squaring.vitrox.stylight.Network.ServiceModule;

@Singleton
@Component(modules = {ApplicationModule.class, ServiceModule.class})
public interface AppComponent {

    Context appContext();

    ApiService apiService();

    OkHttpClient okHttpClient();

    ListAdapter listAdapter();
}
