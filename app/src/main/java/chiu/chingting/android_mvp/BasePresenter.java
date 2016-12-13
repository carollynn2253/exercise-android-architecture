package chiu.chingting.android_mvp;

import android.content.Context;

public interface BasePresenter {
    void create(Context context);
    void start();
    void stop();
}
