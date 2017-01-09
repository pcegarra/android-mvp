package pensamientopositivo.es.mvp.di.module;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pablo on 7/1/17.
 */
@Module
public class ApplicationModule {

    private String mBaseUrl;
    private Context mContext;

    public ApplicationModule(Context context,String baseUrl){
        mContext=context;
        mBaseUrl=baseUrl;
    }

    @Singleton
    @Provides
    GsonConverterFactory provideGsonConverterFactory(){
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    @Named("ok-big")
    OkHttpClient provideOkHttpClient1(){
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    @Named("ok-small")
    OkHttpClient provideOkHttpClient2(){
        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    RxJavaCallAdapterFactory provideRxJavaAdapterFactory(){
        return RxJavaCallAdapterFactory.create();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(@Named("ok-big")OkHttpClient client,
                             GsonConverterFactory converterFactory,
                             RxJavaCallAdapterFactory adapterFactory){

        return new Retrofit.Builder().
                baseUrl(mBaseUrl)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(adapterFactory)
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    Context provideContext(){
        return mContext;
    }
}
