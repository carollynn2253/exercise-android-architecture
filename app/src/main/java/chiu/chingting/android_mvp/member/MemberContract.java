package chiu.chingting.android_mvp.member;

import android.content.Context;

import chiu.chingting.android_mvp.BasePresenter;
import chiu.chingting.android_mvp.BaseView;
import chiu.chingting.android_mvp.model.MemberInfo;


public interface MemberContract {

    interface View extends BaseView<MemberContract.Presenter> {

        void initView(Context context, String title);

        void showProgressDialog();

        void dismissProgressDialog();

        void setViews(MemberInfo data);
    }

    interface Presenter extends BasePresenter {

        void performRequest(Context context);
    }
}
