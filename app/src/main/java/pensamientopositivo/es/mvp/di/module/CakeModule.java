package pensamientopositivo.es.mvp.di.module;

import dagger.Module;
import dagger.Provides;
import pensamientopositivo.es.mvp.api.MvpApiService;
import pensamientopositivo.es.mvp.di.scope.PerActivity;
import pensamientopositivo.es.mvp.mvp.view.MainView;
import retrofit2.Retrofit;

/**
 * Created by pablo on 7/1/17.
 */

@Module
public class CakeModule {

    private MainView mView;

    public CakeModule (MainView view){
        mView=view;
    }

    @PerActivity
    @Provides
    MvpApiService provideApiService(Retrofit retrofit){
        return retrofit.create(MvpApiService.class);
    }

    @PerActivity
    @Provides
    MainView provideView(){
        return mView;
    }
}
