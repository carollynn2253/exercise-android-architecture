package chiu.chingting.android_mvp.member;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;

import chiu.chingting.android_mvp.GlobalConstance;
import chiu.chingting.android_mvp.model.MemberInfo;

public class MemberPresenter implements MemberContract.Presenter {

    Context context;

    @NonNull
    private MemberContract.View mMemberView;


    public MemberPresenter(@NonNull MemberContract.View mMemberView) {
        this.mMemberView = mMemberView;
    }

    @Override
    public void create(Context context) {
        Log.d(GlobalConstance.TAG, "create");
        this.context = context;
    }

    @Override
    public void start() {
        Log.d(GlobalConstance.TAG, "start");
        mMemberView.initView(context, "INIT VIEW");
        performRequest(context);
    }

    @Override
    public void stop() {
        Log.d(GlobalConstance.TAG, "stop");
    }

    @Override
    public void performRequest(Context context) {
        mMemberView.showProgressDialog();


        //got response
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mMemberView.dismissProgressDialog();
                MemberInfo result = new MemberInfo("Ching Ting, Chiu", "detail of Ching Ting, Chiu");
                mMemberView.setViews(result);
            }
        }, GlobalConstance.REQUEST_DURATION);
    }
}
