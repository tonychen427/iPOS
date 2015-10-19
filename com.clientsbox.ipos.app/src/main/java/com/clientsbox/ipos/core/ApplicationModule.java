package com.clientsbox.ipos.core;

import android.app.Application;


import com.clientsbox.ipos.MainActivity;
import com.clientsbox.ipos.MainApplication;
import com.clientsbox.ipos.logic.IInventoryLogic;
import com.clientsbox.ipos.logic.InventoryLogic;
import com.clientsbox.ipos.repository.IInventoryRepository;
import com.clientsbox.ipos.repository.InventoryRepository;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ttran on 10/14/15.
 */

@Module
public class ApplicationModule {
    final MainApplication app;


    public ApplicationModule(MainApplication app){
        this.app = app;
    }

    @Provides
    @PerApp
    MainApplication provideNowDoThisApp() {
        return app;
    }

    @Provides
    @PerApp
    Application provideApplication(MainApplication app) {
        return app;
    }

    @Provides
    @PerApp
    IInventoryLogic inventoryLogicProvider(InventoryLogic Il) {return  Il;}

    @Provides
    @PerApp
    IInventoryRepository inventoryRepositoryProvider(InventoryRepository Ir) {return  Ir;}

}
