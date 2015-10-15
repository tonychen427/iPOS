package com.clientsbox.ipos;

import android.app.Application;
import android.content.Context;

import com.clientsbox.ipos.core.ApplicationComponent;
import com.clientsbox.ipos.core.ApplicationModule;
import com.clientsbox.ipos.core.DaggerApplicationComponent;
import com.clientsbox.ipos.logic.IInventoryLogic;


public class MainApplication extends Application {

    private ApplicationComponent component;
    private IInventoryLogic _inventoryLogic;

    @Override
    public void onCreate(){
        super.onCreate();
        component = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();


    }
    public static ApplicationComponent getComponent(Context context) {
        return ((MainApplication) context.getApplicationContext()).component;
    }

}
