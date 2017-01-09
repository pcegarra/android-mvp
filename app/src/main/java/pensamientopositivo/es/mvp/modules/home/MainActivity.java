package pensamientopositivo.es.mvp.modules.home;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import pensamientopositivo.es.mvp.R;
import pensamientopositivo.es.mvp.base.BaseActivity;
import pensamientopositivo.es.mvp.di.components.DaggerCakeComponent;
import pensamientopositivo.es.mvp.di.module.CakeModule;
import pensamientopositivo.es.mvp.modules.home.adapter.CakeAdapter;
import pensamientopositivo.es.mvp.mvp.model.Cake;
import pensamientopositivo.es.mvp.mvp.presenter.CakePresenter;
import pensamientopositivo.es.mvp.mvp.view.MainView;
import pensamientopositivo.es.mvp.utilities.NetworkUtils;

public class MainActivity extends BaseActivity implements MainView {

    private final static String TAG = MainActivity.class.getName();

    @Inject protected CakePresenter mPresenter;

    @BindView(R.id.list_main)
    RecyclerView mListCakes;

    private CakeAdapter mAdapter;

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        initializeList();

        if(NetworkUtils.isNetworkAvailable(this)){
            mPresenter.getCakes();
        }
        else{
            mPresenter.getCakesFromDb();
        }

        Log.w(TAG," get cakes");

    }


    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerCakeComponent.builder()
                .applicationComponent(getApplicationComponent())
                .cakeModule(new CakeModule(this))
                .build().inject(this);
    }

    @Override
    public void onCakeLoaded(List<Cake> cakes) {
        mAdapter.addCakes(cakes);
    }

    @Override
    public void onShowDialog(String message) {
        showDialog(message);
    }

    @Override
    public void onHideDialog() {
        hideDialog();
    }

    @Override
    public void onShowToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClearItems() {
        mAdapter.clearItems();
    }

    private void initializeList() {
        mListCakes.setHasFixedSize(true);
        mListCakes.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mAdapter = new CakeAdapter(this,getLayoutInflater());
        mListCakes.setAdapter(mAdapter);
    }
}