package pensamientopositivo.es.mvp.di.components;

import dagger.Component;
import pensamientopositivo.es.mvp.di.module.CakeModule;
import pensamientopositivo.es.mvp.di.scope.PerActivity;
import pensamientopositivo.es.mvp.modules.home.MainActivity;

/**
 * Created by pablo on 7/1/17.
 */
@PerActivity
@Component(modules = CakeModule.class,dependencies = ApplicationComponent.class)
public interface CakeComponent {

    void inject(MainActivity activity);
}
