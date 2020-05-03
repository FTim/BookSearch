package hu.bme.aut.booksearch.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.booksearch.utilities.Utilities;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create());

    }

    @Provides
    @Singleton
    public BookSearchApi provideBookSearchApi(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.baseUrl(Utilities.BASE_ADDRESS).build().create(BookSearchApi.class);
    }
}
