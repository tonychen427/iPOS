package com.clientsbox.ipos;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.clientsbox.ipos.adapter.ShoppingCartAdapter;
import com.clientsbox.ipos.fragmentPageAdapter.MenuPageAdapter;
import com.clientsbox.ipos.logic.IInventoryLogic;
import com.clientsbox.ipos.transfer.object.InventoryCategory;
import com.clientsbox.ipos.transfer.object.InventoryItem;
import com.clientsbox.ipos.transfer.object.InventoryMenu;
import com.clientsbox.ipos.transfer.object.ShoppingCart;
import com.clientsbox.ipos.widgets.pageslidingtabstrip.PagerSlidingTabStrip;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @Inject
    IInventoryLogic _inventoryLogic;

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.tabs)
    PagerSlidingTabStrip tabs;
    @InjectView(R.id.pager)
    ViewPager pager;
    @InjectView(R.id.Shoppingcart_listView)
    ListView shoppingcart_listView;
    @InjectView(R.id.totalPrice)
    TextView totalPriceLabel;

    ShoppingCartAdapter mShoppingCartAdapter;

    private MenuPageAdapter adapter;
    private Drawable oldBackground = null;
    private int currentColor;
    private SystemBarTintManager mTintManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        MainApplication.getComponent(this).inject(this);
        InventoryMenu mInvMenu = _inventoryLogic.getAllMenuByStoreId(1000);

        tabs.setBackgroundColor(getResources().getColor(R.color.green));
        toolbar.setBackgroundColor(getResources().getColor(R.color.green));
        setSupportActionBar(toolbar);

        mTintManager = new SystemBarTintManager(this);
        mTintManager.setStatusBarTintEnabled(true);

        adapter = new MenuPageAdapter(getSupportFragmentManager(), mInvMenu.getCategoryList());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
        pager.setPageMargin(pageMargin);
        pager.setCurrentItem(0);
        //changeColor(getResources().getColor(R.color.green));
        //changeColor(R.color.green);
        tabs.setOnTabReselectedListener(new PagerSlidingTabStrip.OnTabReselectedListener() {
            @Override
            public void onTabReselected(int position) {
                Toast.makeText(MainActivity.this, "Tab reselected: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        List<ShoppingCart> mList = new ArrayList<>();

        mShoppingCartAdapter = new ShoppingCartAdapter(this, mList);
        shoppingcart_listView.setAdapter(mShoppingCartAdapter);
        shoppingcart_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ShoppingCartAdapter associatedAdapter = (ShoppingCartAdapter)(parent.getAdapter());
                List<ShoppingCart> associatedList = associatedAdapter.getList();
                ShoppingCart associatedItem = associatedList.get(position);
                if(removeItemToList(associatedList,associatedItem)){
                    view.invalidate();
                    associatedAdapter.notifyDataSetChanged();


                    Double mTotalPrice = Double.parseDouble(totalPriceLabel.getText().toString());
                    mTotalPrice = mTotalPrice - associatedItem.getPrice();
                    DecimalFormat f = new DecimalFormat("##.00");
                    totalPriceLabel.setText(f.format(mTotalPrice).toString());

                }
            }
        });

    }

    private boolean removeItemToList(List<ShoppingCart> l, ShoppingCart it){
        boolean result = l.remove(it);
        return result;
    }

    private boolean addItemToList(List<ShoppingCart> l, ShoppingCart it){
        boolean result = l.add(it);
        return result;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_contact:
             //   QuickContactFragment.newInstance().show(getSupportFragmentManager(), "QuickContactFragment");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void changeColor(int newColor) {
        tabs.setBackgroundColor(newColor);
        mTintManager.setTintColor(newColor);
        // change ActionBar color just if an ActionBar is available
        Drawable colorDrawable = new ColorDrawable(newColor);
        Drawable bottomDrawable = new ColorDrawable(getResources().getColor(android.R.color.transparent));
        LayerDrawable ld = new LayerDrawable(new Drawable[]{colorDrawable, bottomDrawable});
        if (oldBackground == null) {
            getSupportActionBar().setBackgroundDrawable(ld);
        } else {
            TransitionDrawable td = new TransitionDrawable(new Drawable[]{oldBackground, ld});
            getSupportActionBar().setBackgroundDrawable(td);
            td.startTransition(200);
        }

        oldBackground = ld;
        currentColor = newColor;
    }

    public void onColorClicked(View v) {
        int color = Color.parseColor(v.getTag().toString());
        changeColor(color);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentColor", currentColor);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentColor = savedInstanceState.getInt("currentColor");
        changeColor(currentColor);
    }

}
