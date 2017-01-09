package pensamientopositivo.es.mvp.mvp.presenter;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import pensamientopositivo.es.mvp.api.MvpApiService;
import pensamientopositivo.es.mvp.base.BasePresenter;
import pensamientopositivo.es.mvp.mapper.CakeMapper;
import pensamientopositivo.es.mvp.mvp.model.Cake;
import pensamientopositivo.es.mvp.mvp.model.CakesResponse;
import pensamientopositivo.es.mvp.mvp.model.Storage;
import pensamientopositivo.es.mvp.mvp.view.MainView;
import rx.Observable;
import rx.Observer;

/**
 * Created by pablo on 8/1/17.
 */

public class CakePresenter extends BasePresenter<MainView> implements Observer<CakesResponse> {

    private final static String TAG = CakePresenter.class.getName();

    @Inject protected MvpApiService mApiService;
    @Inject protected CakeMapper mCakeMapper;
    @Inject protected Storage mStorage;


    @Inject
    CakePresenter(){

    }

    public void getCakes(){
        Log.w(TAG," cake loaded");
        getView().onShowDialog("Haciendo cakes!");
        Observable<CakesResponse> cakesResponseObservable = mApiService.getCakes();
        subscribe(cakesResponseObservable,this);
    }

    @Override
    public void onCompleted() {
        getView().onHideDialog();
        getView().onShowToast("Cakes horneados!");

    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG," cake error"+e.getMessage());
        getView().onShowToast("Se quemaron los cakes"+e.getMessage());

    }

    @Override
    public void onNext(CakesResponse cakesResponse) {
        List<Cake> cakes = mCakeMapper.mapCakes(mStorage,cakesResponse);
        getView().onClearItems();
        getView().onCakeLoaded(cakes);
    }

    public void getCakesFromDb() {
        List<Cake> cakes = mStorage.getSavedCakes();
        getView().onClearItems();
        getView().onCakeLoaded(cakes);
    }
}
