package chiu.chingting.calculator.Home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

public class HomePresenter<P> implements HomeContract.Presenter {

    Context context;

    @NonNull
    private HomeContract.View mHomeView;


    public HomePresenter(@NonNull HomeContract.View mHomeView) {
        this.mHomeView = mHomeView;
    }

    @Override
    public void create(Context context) {
        Log.d("tttt", "create");
        this.context = context;
    }

    @Override
    public void start() {
        Log.d("tttt", "start");
    }

    @Override
    public void stop() {
        Log.d("tttt", "stop");
        mHomeView.initView(context, "STOPPED");
    }

    @Override
    public void performRequest(Context context) {
        Log.d("tttt", "performRequest");
        mHomeView.showProgressDialog();
    }
}
