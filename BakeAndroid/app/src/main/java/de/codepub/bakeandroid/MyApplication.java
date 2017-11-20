package de.codepub.bakeandroid;


import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import de.codepub.bakeandroid.di.AppInjector;
import timber.log.Timber;

public class MyApplication extends Application implements HasActivityInjector {
    //todo DI: https://google.github.io/dagger/
    //https://guides.codepath.com/android/dependency-injection-with-dagger-2
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        initTimber();
        AppInjector.init(this);
    }

    private void initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }


}
