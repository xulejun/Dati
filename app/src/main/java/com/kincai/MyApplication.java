package com.kincai;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by XLJ on 2019/9/23.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //≥ı ºªØ
        Bmob.initialize(this, "9c2574ae7273ad2b0dffcebfc5c5e546");
    }
}
