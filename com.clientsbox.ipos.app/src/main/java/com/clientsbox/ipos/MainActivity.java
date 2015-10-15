package com.clientsbox.ipos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.clientsbox.ipos.logic.IInventoryLogic;
import com.clientsbox.ipos.transfer.object.InventoryMenu;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {


    @Inject
    IInventoryLogic _inventoryLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainApplication.getComponent(this).inject(this);

        InventoryMenu mInvMenu = _inventoryLogic.getAllMenuByStoreId(1000);

    }
}
