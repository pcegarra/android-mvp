package pensamientopositivo.es.mvp.base;

import javax.inject.Inject;

import pensamientopositivo.es.mvp.mvp.view.BaseView;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pablo on 7/1/17.
 */

public class BasePresenter<V extends BaseView> {

    @Inject protected V mView;

    protected V getView(){
        return mView;
    }

    protected <T> void subscribe(Observable<T> observable,Observer<T> observer) {

        observable.subscribeOn(Schedulers.newThread())
                .toSingle()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
