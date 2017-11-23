package de.codepub.bakeandroid.di;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.codepub.bakeandroid.BuildConfig;
import de.codepub.bakeandroid.data.ApiClient;
import de.codepub.bakeandroid.ui.recipelist.RecipeListViewModel;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module()
public class AppModule {
    //todo declare all object instances here

    @Singleton
    @Provides
    RecipeListViewModel providesRecipeListViewModel() {
        return new RecipeListViewModel();
    }

    @Singleton
    @Provides
    ApiClient provideApiClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .readTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES);

        if (BuildConfig.DEBUG)
            enableLogging(httpClient);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient.build())
                .build();

        return retrofit.create(ApiClient.class);
    }

    private void enableLogging(OkHttpClient.Builder httpClient) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);
    }
}
