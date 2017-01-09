package pensamientopositivo.es.mvp.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import pensamientopositivo.es.mvp.application.MvpApplication;
import pensamientopositivo.es.mvp.di.module.ApplicationModule;
import retrofit2.Retrofit;

/**
 * Created by pablo on 7/1/17.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Retrofit exposeRetrofit();

    Context exposeContext();
}
