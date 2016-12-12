package chiu.chingting.android_mvp.member;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import chiu.chingting.android_mvp.BaseActivity;
import chiu.chingting.android_mvp.R;
import chiu.chingting.android_mvp.model.MemberInfo;

/**
 * Created by ting.chiu on 2016/12/12.
 */

public class MemberActivity extends BaseActivity implements MemberContract.View {

    private MemberContract.Presenter presenter;
    private ProgressDialog progressDialog;

    @BindView(R.id.hello_string)
    TextView helloString;

    @Override
    protected int getContentView() {
        return R.layout.activity_member;
    }

    @Override
    public void setPresenter(MemberContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(this);

        presenter = new MemberPresenter(this);
        presenter.create(this);
        presenter.start();
    }

    @Override
    public void initView(Context context, String title) {
        helloString.setText(getString(R.string.member_hello_string, "Ching Ting, Chiu"));
    }

    @Override
    public void showProgressDialog() {
        progressDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        progressDialog.dismiss();
    }

    @Override
    public void setViews(MemberInfo data) {
        helloString.setText(getString(R.string.member_hello_string, "Ching Ting, Chiu") + "\n" + data.getDetail());
    }

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, MemberActivity.class);
        activity.startActivity(intent);
    }
}
