package pensamientopositivo.es.mvp.application;

import android.app.Application;
import android.util.Log;

import pensamientopositivo.es.mvp.di.components.ApplicationComponent;
import pensamientopositivo.es.mvp.di.components.DaggerApplicationComponent;
import pensamientopositivo.es.mvp.di.module.ApplicationModule;

/**
 * Created by pablo on 7/1/17.
 */

public class MvpApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.w("MvpApplication"," onCreate");

        initializeApplicationComponent();
        Log.w("MvpApplication"," onCreate 2" );

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }

    private void initializeApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this, "https://gist.githubusercontent.com"))
                .build();
    }
}
