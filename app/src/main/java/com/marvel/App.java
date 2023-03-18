package com.marvel;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.marvel.utils.Logger;

/**
 * Created by bkhadra on 3/15/2023.
 */
public class App extends Application implements Application.ActivityLifecycleCallbacks {//, Configuration.Provide

private final String TAG = App.class.getSimpleName();
    private static App sInstance;
    private static App mContext;

    public App() {
        sInstance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        registerActivityLifecycleCallbacks(new AdjustLifecycleCallbacks());
    }

    private static final class AdjustLifecycleCallbacks implements ActivityLifecycleCallbacks {
        @Override
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(@NonNull Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(@NonNull Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(@NonNull Activity activity) {

        }
    }




    public static App getInstance() {
        return sInstance;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onConfigurationChanged(android.content.res.Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onActivityCreated(Activity arg0, Bundle arg1) {
        Logger.i("", "onActivityCreated");

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Logger.i("", "onActivityDestroyed ");
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Logger.i("", "onActivityPaused " + activity.getClass());
    }

    @Override
    public void onActivityResumed(Activity activity) {
        Logger.i("", "onActivityResumed " + activity.getClass());
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Logger.i("", "onActivitySaveInstanceState");

    }

    @Override
    public void onActivityStarted(Activity activity) {
        Logger.i("", "onActivityStarted");
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Logger.i("", "onActivityStopped");

    }
    @Override
    public void onTerminate() {
        super.onTerminate();
    }



}
