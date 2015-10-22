package com.clientsbox.ipos.fragmentPageAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.clientsbox.ipos.SuperAwesomeCardFragment;
import com.clientsbox.ipos.transfer.object.InventoryCategory;

import java.util.List;

/**
 * Created by ttran on 10/21/15.
 */
public class MenuPageAdapter extends FragmentPagerAdapter {

    private final String[] TITLES = {"Categories", "Home", "Top Paid", "Top Free", "Top Grossing", "Top New Paid", "Top New Free", "Trending"};

    private List<InventoryCategory> _InventoryCategory;

    public MenuPageAdapter(FragmentManager fm, List<InventoryCategory> mInventoryCategory ) {
        super(fm);
        _InventoryCategory = mInventoryCategory;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return _InventoryCategory.get(position).getTitle();
    }

    @Override
    public int getCount() {
        return _InventoryCategory.size();
    }

    @Override
    public Fragment getItem(int position) {
        return SuperAwesomeCardFragment.newInstance(position, _InventoryCategory);
    }
}