package com.clientsbox.ipos.core;

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
