package pensamientopositivo.es.mvp.mvp.view;

import java.util.List;

import pensamientopositivo.es.mvp.mvp.model.Cake;

/**
 * Created by pablo on 8/1/17.
 */

public interface MainView extends BaseView{

    void onCakeLoaded(List<Cake> Cackes);

    void onShowDialog(String message);

    void onHideDialog();

    void onShowToast(String message);

    void onClearItems();
}
