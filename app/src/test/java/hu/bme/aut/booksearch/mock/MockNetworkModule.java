package hu.bme.aut.booksearch.mock;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.booksearch.network.BookSearchApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MockNetworkModule {

    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create());

    }

    @Provides
    @Singleton
    public BookSearchApi provideArtistsApi(Retrofit.Builder retrofitBuilder) {
        return new MockBookSearchApi();
    }
}
