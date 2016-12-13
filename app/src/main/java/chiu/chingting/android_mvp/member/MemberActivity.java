package chiu.chingting.android_mvp.member;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tbruyelle.rxpermissions.RxPermissions;

import butterknife.BindView;
import butterknife.OnClick;
import chiu.chingting.android_mvp.BaseActivity;
import chiu.chingting.android_mvp.R;
import chiu.chingting.android_mvp.model.MemberInfo;

/**
 * Created by ting.chiu on 2016/12/12.
 */

public class MemberActivity extends BaseActivity implements MemberContract.View {
    private static final String TAG = "Member";

    private MemberContract.Presenter presenter;
    private ProgressDialog progressDialog;

    @BindView(R.id.hello_string)
    TextView helloString;
    @BindView(R.id.detail)
    TextView detail;
    @BindView(R.id.request_permissions)
    Button openCamera;

    private RxPermissions rxPermissions;

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
        rxPermissions = new RxPermissions(this); // where this is an Activity instance

        presenter = new MemberPresenter(this);
        presenter.create(this);
        presenter.start();
    }

    @Override
    public void initView(Context context, String title) {
        openCamera.setVisibility(View.GONE);

        helloString.setText(getString(R.string.member_hello_string, "Ching Ting, Chiu"));
    }

    @OnClick(R.id.request_permissions)
    void requestPermissions() {
        rxPermissions
                .requestEach(Manifest.permission.CAMERA, Manifest.permission.READ_PHONE_STATE)
                .subscribe(permission -> {
                    String permissionName = permission.name.substring(permission.name.lastIndexOf(".") + 1);
                    if (permission.granted) {
                        // Permission is granted !
                        Toast.makeText(MemberActivity.this,
                                getString(R.string.permission_allow, permissionName),
                                Toast.LENGTH_SHORT).show();
                    } else if (permission.shouldShowRequestPermissionRationale) {
                        // Denied permission without ask never again
                        Toast.makeText(MemberActivity.this,
                                getString(R.string.permission_deny, permissionName),
                                Toast.LENGTH_SHORT).show();
                    } else {
                        // Denied permission with ask never again
                        // Need to go to the settings
                        Toast.makeText(MemberActivity.this,
                                getString(R.string.permission_deny_permanently, permissionName),
                                Toast.LENGTH_SHORT).show();
                    }
                });
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
        openCamera.setVisibility(View.VISIBLE);

        helloString.setText(getString(R.string.member_hello_string, "Ching Ting, Chiu"));
        detail.setText(data.getDetail());
    }

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, MemberActivity.class);
        activity.startActivity(intent);
    }

}
