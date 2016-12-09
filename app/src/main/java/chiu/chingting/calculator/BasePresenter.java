package chiu.chingting.calculator;

import android.content.Context;

public interface BasePresenter {
    void create(Context context);
    void start();
    void stop();
}
