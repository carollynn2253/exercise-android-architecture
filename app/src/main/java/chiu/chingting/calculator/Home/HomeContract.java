package chiu.chingting.calculator.Home;

import android.content.Context;

import chiu.chingting.calculator.BasePresenter;
import chiu.chingting.calculator.BaseView;
import chiu.chingting.calculator.model.MemberInfo;


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
