package chiu.chingting.calculator.Home;

import android.content.Context;

import chiu.chingting.calculator.BasePresenter;
import chiu.chingting.calculator.BaseView;


public interface HomeContract {

    interface View<T> extends BaseView<HomeContract.Presenter> {

        void initView(Context context, String title);

        void showProgressDialog();

        void dismissProgressDialog();

        void setViews(T data);

    }

    interface Presenter extends BasePresenter {

        void performRequest(Context context);

    }
}
