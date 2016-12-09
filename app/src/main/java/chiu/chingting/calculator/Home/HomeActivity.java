package chiu.chingting.calculator.Home;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import chiu.chingting.calculator.BaseActivity;
import chiu.chingting.calculator.R;
import chiu.chingting.calculator.model.MemberInfo;


public class HomeActivity extends BaseActivity implements HomeContract.View<MemberInfo> {

    private HomeContract.Presenter presenter;

    private ProgressDialog progressDialog;

    @BindView(R.id.text)
    TextView text;

    @Override
    protected int getContentView() {
        return R.layout.activity_home;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(this);

        presenter = new HomePresenter<MemberInfo>(this);
        presenter.create(this);
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @OnClick(R.id.start_button)
    void getData() {
        presenter.start();
        presenter.performRequest(this);
    }

    @OnClick(R.id.stop_button)
    void stop() {
        presenter.stop();
    }

    //HomeContract
    @Override
    public void initView(Context context, String title) {
        Log.d("tttt", "initView");

        text.setText(title);
    }

    //HomeContract
    @Override
    public void showProgressDialog() {
        Log.d("tttt", "show PD");
        progressDialog.show();
    }

    //HomeContract
    @Override
    public void dismissProgressDialog() {
        Log.d("tttt", "dismiss PD");
        progressDialog.dismiss();
    }

    //HomeContract
    @Override
    public void setViews(MemberInfo data) {
        Log.d("tttt", "got data! " + data.getMemberName());

    }
}
