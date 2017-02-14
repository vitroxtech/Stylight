package squaring.vitrox.stylight.Network;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import squaring.vitrox.stylight.Common.Config;
import squaring.vitrox.stylight.DependencyInjection.Module.ApplicationModule;

@Module(includes = ApplicationModule.class)
public class ServiceModule {

    private static final String HEADER_LOCALE = "X-Locale";
    private static final String HEADER_LOCALE_VAL = "de_DE";
    private static final String HEADER_API_KEY = "X-apiKey";
    private static final String HEADER_API_VAL = "C6490912AB3211E680F576304DEC7EB7";

    @Provides
    @Singleton
    public ApiService apiService(OkHttpClient client) {

        String demoUrl = Config.BASE_URL;
        //Jackson Mapper and deserializer
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return new Retrofit.Builder()
                .baseUrl(demoUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .client(client)
                .build()
                .create(ApiService.class);
    }

    @Provides
    @Singleton
    public OkHttpClient okHttpClient() {

        OkHttpClient.Builder cliente = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                System.out.println("OkHttp: " + message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        cliente.addInterceptor((new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader(HEADER_LOCALE, HEADER_LOCALE_VAL)
                        .addHeader(HEADER_API_KEY, HEADER_API_VAL)
                        .build();
                return chain.proceed(request);
            }
        })).addInterceptor(loggingInterceptor);
        return cliente.build();

    }


}
