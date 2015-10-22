package com.clientsbox.ipos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.clientsbox.ipos.adapter.CategoryAdapter;
import com.clientsbox.ipos.adapter.CustomGrid;
import com.clientsbox.ipos.adapter.ShoppingCartAdapter;
import com.clientsbox.ipos.transfer.object.InventoryCategory;
import com.clientsbox.ipos.transfer.object.InventoryItem;
import com.clientsbox.ipos.transfer.object.InventoryMenu;
import com.clientsbox.ipos.transfer.object.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SuperAwesomeCardFragment extends Fragment {

    private static final String ARG_POSITION = "position";

    @InjectView(R.id.textView)
    TextView textView;

    private int position;

    GridView grid;

    int[] imageId = {
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger,
            R.drawable.hamburger
    };
    static List<InventoryCategory> _inventoryCategory;

    public static SuperAwesomeCardFragment newInstance(int position,  List<InventoryCategory> mInventoryCategory) {
        SuperAwesomeCardFragment f = new SuperAwesomeCardFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        _inventoryCategory = mInventoryCategory;
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_card,container,false);
        ButterKnife.inject(this, rootView);


        CategoryAdapter mCategoryAdapter = new CategoryAdapter(container.getContext(),_inventoryCategory.get(position).getItemList(),imageId);
        //CustomGrid adapter = new CustomGrid(container.getContext(), web, imageId);
        GridView grid = (GridView) rootView.findViewById(R.id.grid);
        grid.setAdapter(mCategoryAdapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,int positionItem, long id) {
                InventoryItem mItem = _inventoryCategory.get(position).getItemList().get(positionItem);
                Toast.makeText(container.getContext(), "You Clicked at " + mItem.getTitle(), Toast.LENGTH_SHORT).show();

                int itemId = mItem.getId();
                String itemName = mItem.getTitle();
                Double itemPrice = mItem.getPrice();

                ShoppingCartAdapter mShoppingCartAdapter =  ((MainActivity)getActivity()).mShoppingCartAdapter;
                List<ShoppingCart> myShoppingCartList =  mShoppingCartAdapter.getList();
                addItemToList(myShoppingCartList,new ShoppingCart(String.valueOf(itemId),itemName, itemName, 1, itemPrice));
                mShoppingCartAdapter.notifyDataSetChanged();
            }
        });

        ViewCompat.setElevation(rootView, 0);
        textView.setText("CARD "+position);
        return rootView;
    }

    private boolean addItemToList(List<ShoppingCart> l, ShoppingCart it){
        boolean result = l.add(it);
        return result;
    }
}