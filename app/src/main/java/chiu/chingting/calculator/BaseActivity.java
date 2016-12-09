package chiu.chingting.calculator;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

//    @Nullable
//    @BindView(R.id.toolbar)
//    protected Toolbar toolbar;

    @LayoutRes
    protected abstract int getContentView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);

//        if (toolbar != null) {
//            setSupportActionBar(toolbar);
//        }

    }

}
