package chiu.chingting.android_mvp.Home;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;

import chiu.chingting.android_mvp.GlobalConstance;
import chiu.chingting.android_mvp.model.MemberInfo;

public class HomePresenter implements HomeContract.Presenter {

    Context context;

    @NonNull
    private HomeContract.View mHomeView;


    public HomePresenter(@NonNull HomeContract.View mHomeView) {
        this.mHomeView = mHomeView;
    }

    @Override
    public void create(Context context) {
        Log.d(GlobalConstance.TAG, "create");
        this.context = context;
    }

    @Override
    public void start() {
        Log.d(GlobalConstance.TAG, "start");
        mHomeView.initView(context, "INIT VIEW");
    }

    @Override
    public void stop() {
        Log.d(GlobalConstance.TAG, "stop");
    }

    @Override
    public void performRequest(Context context) {
        Log.d(GlobalConstance.TAG, "performRequest");
        mHomeView.showProgressDialog();


        //got response
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mHomeView.dismissProgressDialog();
                MemberInfo result = new MemberInfo("CCT", "Detail of CCT");
                mHomeView.setViews(result);
            }
        }, GlobalConstance.REQUEST_DURATION);
    }
}
