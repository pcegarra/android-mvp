package pensamientopositivo.es.mvp.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import pensamientopositivo.es.mvp.application.MvpApplication;
import pensamientopositivo.es.mvp.di.components.ApplicationComponent;

/**
 * Created by pablo on 7/1/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;
    private Unbinder mUnbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w("BaseActivity"," onCreate");
        setContentView(getContentView());
        mUnbinder = ButterKnife.bind(this);
        onViewReady(savedInstanceState,getIntent());
    }

    @Override
    protected void onDestroy() {
        mUnbinder.unbind();
        super.onDestroy();
    }

    @CallSuper
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        resolveDaggerDependency();
    }


    protected void showDialog(String message){
        if(mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCancelable(true);
        }
        mProgressDialog.setMessage(message);
        mProgressDialog.show();
    }

    protected void hideDialog(){
        if(mProgressDialog!=null && mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }

    protected ApplicationComponent getApplicationComponent(){
        return ((MvpApplication)getApplication()).getApplicationComponent();
    }

    public abstract int getContentView();

    protected void resolveDaggerDependency(){}


}
