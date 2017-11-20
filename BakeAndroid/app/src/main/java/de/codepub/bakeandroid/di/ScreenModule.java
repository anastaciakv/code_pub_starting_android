package de.codepub.bakeandroid.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import de.codepub.bakeandroid.MainActivity;


@Module
public abstract class ScreenModule {

    //todo declare each screen in this module
    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

}
