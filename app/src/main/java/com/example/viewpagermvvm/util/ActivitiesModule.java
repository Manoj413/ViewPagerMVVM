package com.example.viewpagermvvm.util;

import com.example.viewpagermvvm.base.BaseActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
interface ActivitiesModule {
    @ContributesAndroidInjector
    BaseActivity contributeActivityAndroidInjector();

}