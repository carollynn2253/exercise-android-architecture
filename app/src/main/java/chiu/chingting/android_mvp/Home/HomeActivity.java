package chiu.chingting.android_mvp.Home;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import chiu.chingting.android_mvp.BaseActivity;
import chiu.chingting.android_mvp.GlobalConstance;
import chiu.chingting.android_mvp.R;
import chiu.chingting.android_mvp.model.MemberInfo;


public class HomeActivity extends BaseActivity implements HomeContract.View {

    private HomeContract.Presenter presenter;

    private ProgressDialog progressDialog;

    @BindView(R.id.text)
    TextView text;

    @Override
    protected int getContentView() {
        return R.layout.activity_home;
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(this);

        presenter = new HomePresenter(this);
        presenter.create(this);
        presenter.start(); //initView
    }

    //perform method
    @OnClick(R.id.button1)
    void getData() {
        presenter.performRequest(this);
    }

    //define method content for Presenter
    @Override
    public void initView(Context context, String title) {
        Log.d(GlobalConstance.TAG, "initView");
        text.setText(title);
    }

    @Override
    public void showProgressDialog() {
        Log.d(GlobalConstance.TAG, "show PD");
        progressDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        Log.d(GlobalConstance.TAG, "dismiss PD");
        progressDialog.dismiss();
    }

    @Override
    public void setViews(MemberInfo data) {
        Log.d(GlobalConstance.TAG, "got data! " + data.getMemberName());

        text.setText(data.getMemberName());
    }
}
