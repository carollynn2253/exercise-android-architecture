package chiu.chingting.android_mvp.Home;

import android.content.Context;

import chiu.chingting.android_mvp.BasePresenter;
import chiu.chingting.android_mvp.BaseView;
import chiu.chingting.android_mvp.model.MemberInfo;


public interface HomeContract {

    interface View extends BaseView<HomeContract.Presenter> {

        void initView(Context context, String title);

        void showProgressDialog();

        void dismissProgressDialog();

        void setViews(MemberInfo data);
    }

    interface Presenter extends BasePresenter {

        void performRequest(Context context);

    }
}
