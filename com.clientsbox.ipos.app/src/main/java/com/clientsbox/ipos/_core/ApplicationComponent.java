package com.clientsbox.ipos._core;

import android.app.Application;

import com.clientsbox.ipos.MainActivity;

import dagger.Component;

@PerApp
@Component( modules = {
        ApplicationModule.class,
        })
public interface ApplicationComponent {

    void inject(MainActivity activity);
    Application application();
}
