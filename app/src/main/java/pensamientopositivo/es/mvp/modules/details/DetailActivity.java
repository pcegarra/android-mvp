package pensamientopositivo.es.mvp.modules.details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pensamientopositivo.es.mvp.R;
import pensamientopositivo.es.mvp.base.BaseActivity;

public class DetailActivity extends BaseActivity{


    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_detail;
    }
}
